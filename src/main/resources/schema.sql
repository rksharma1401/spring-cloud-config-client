CREATE TABLE category(
  id INTEGER  PRIMARY KEY,
  category_name  VARCHAR(500) ,
  CONSTRAINT category_categoryName_unique UNIQUE (category_name)
); 