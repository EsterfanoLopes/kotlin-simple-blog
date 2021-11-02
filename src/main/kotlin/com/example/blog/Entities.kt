package com.example.blog

import java.time.LocalDateTime
import javax.persistence.GenerationType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.ManyToOne
import javax.persistence.Id


@Entity(name="articles")
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)

@Entity(name = "users")
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)