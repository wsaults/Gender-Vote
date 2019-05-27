package com.wsaults.gendervote;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="votes")
public class Vote {
  @Id final private String id;
  final private String gender;
}