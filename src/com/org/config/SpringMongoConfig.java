package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;
 
/**
 * @author Ajay Chauhan
 *
 */
@Configuration
public class SpringMongoConfig
{
	
	/*
	 * DB IP/port/credentials hard coded for now.
	 * Could be picked from properties file.
	 */
	private final String DB_IP = "127.0.0.1";
	private final int DB_PORT = 27017;
	private final String DB_MEDIA_NAME = "media";
 
	/**
	 * @return mongo db factory for media db
	 * @throws Exception
	 */
	public @Bean
	MongoDbFactory mongoMediaDbFactory() throws Exception
	{
		return new SimpleMongoDbFactory(new MongoClient(DB_IP, DB_PORT), DB_MEDIA_NAME);
	}
 
	/**
	 * @return mongo template for db operation on media DB
	 * @throws Exception
	 */
	public @Bean
	MongoTemplate mongoMediaTemplate() throws Exception
	{
		
		//Remove _class from mongo db by adding custom type mapper
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoMediaDbFactory());
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
	 
		MongoTemplate mongoMediaTemplate = new MongoTemplate(mongoMediaDbFactory(), converter);
 
		return mongoMediaTemplate;
 
	}
 
}
