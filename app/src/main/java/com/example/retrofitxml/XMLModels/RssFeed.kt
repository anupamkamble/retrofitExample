package com.example.retrofitxml.XMLModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root


@Root(name = "rss", strict =  false)
public class RssFeed{

    @Element(name = "title")
    @Path ("channel")
    lateinit var channelTitle: String


    @ElementList(name = "item")
    @Path ("channel")
    lateinit var articleList : List<Article>


}