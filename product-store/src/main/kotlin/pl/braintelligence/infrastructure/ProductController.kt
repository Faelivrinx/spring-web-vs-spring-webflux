package pl.braintelligence.infrastructure

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.domain.Product
import pl.braintelligence.domain.ProductService
import pl.braintelligence.infrastructure.dto.NewProduct
import reactor.core.publisher.Mono

@RestController("products")
class ProductController(
        private val productService: ProductService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody newProduct: Mono<NewProduct>): Mono<Product> =
            productService.createProduct(newProduct)
}
