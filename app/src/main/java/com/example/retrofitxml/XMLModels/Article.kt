package com.example.retrofitxml.XMLModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "title", strict = false    )
public class  Article{

    @Element(name = "title")
    lateinit var title: String

    @Element(name = "description")
    lateinit var description : String

    @Element(name = "link")
    lateinit var link: String
}