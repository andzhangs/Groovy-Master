package main.json

import main.objectoriention.Persons
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def list = [new Persons(name: "Dean", age: 100), new Persons(name: "Child", age: 20)]
def jsonstr = JsonOutput.toJson(list)
println "打印：" + jsonstr.toString()

def jsonSlpuer = new JsonSlurper()
def obj = jsonSlpuer.parseText('{ "myList": [4, 8, 15, 16, 23, 42] }')
