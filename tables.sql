CREATE TABLE users(
    userID INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (`userID`)
);

CREATE TABLE devices (
  phoneNumber VARCHAR(45) NOT NULL,
  userID INT NOT NULL,
  dataPlanID INT NOT NULL,
  deviceName VARCHAR(45) NOT NULL,
  deviceDescription VARCHAR(45) NOT NULL,
  PRIMARY KEY (`phoneNumber`),
  FOREIGN KEY (`userID`)
  REFERENCES users(userID),
  FOREIGN KEY (`dataPlanID`)
  references data_plans(dataPlanID)
);
  
CREATE TABLE data_plans (
  dataPlanID INT NOT NULL AUTO_INCREMENT,
  numberOfDevices INT NOT NULL DEFAULT 0,
  planDescription VARCHAR(45) NOT NULL,
  costPerDevice DOUBLE NOT NULL,
  PRIMARY KEY (`dataPlanID`)
);
