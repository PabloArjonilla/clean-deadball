module pmac.example.spring {
	requires pmac.example.config;
	requires pmac.example.usecase;
	requires pmac.example.controller;
	requires spring.web;
	requires spring.beans;

	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires com.fasterxml.jackson.databind;
	requires jackson.annotations;

	exports es.pmac.example.spring;
	exports es.pmac.example.spring.config;
	opens es.pmac.example.spring.config to spring.core;
}
