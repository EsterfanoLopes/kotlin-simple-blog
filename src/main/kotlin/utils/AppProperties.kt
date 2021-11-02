package utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties {
    @Value("\${blog.title}")
    lateinit var blogTitle: String

    @Value("\${blog.banner.title}")
    lateinit var bannerTitle: String

    @Value("\${blog.banner.content}")
    lateinit var bannerContent: String
}