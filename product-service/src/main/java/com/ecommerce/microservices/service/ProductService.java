package com.ecommerce.microservices.service;

import com.ecommerce.microservices.dto.ProductRequest;
import com.ecommerce.microservices.dto.ProductResponse;
import com.ecommerce.microservices.model.Product;
import com.ecommerce.microservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;


    public ProductResponse createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .skuCode(productRequest.skuCode())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(),product.getSkuCode(), product.getName(),product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getSkuCode(), product.getName(),product.getDescription(), product.getPrice()))
                .toList();
    }

    public String deleteProduct(String skuCode) {
        if (productRepository.existsBySkuCode(skuCode)) {
            productRepository.deleteBySkuCode(skuCode);
            return "Product with SKU " + skuCode + " deleted successfully.";
        } else {
            return "Product with SKU " + skuCode + " not found.";
        }
    }

    public String updateProduct(String name, String updateSkuCode) {
        Optional<Product> existingProductOpt = productRepository.findByName(name);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            // Update fields
            existingProduct.setSkuCode(updateSkuCode);

            // Add other fields as necessary

            // Save updated product
            productRepository.save(existingProduct);

            return "Product with name " + name + "got updated with " + updateSkuCode  + " successfully.";
        } else {
            return "Product with name " + name + " not found.";
        }
    }


}
