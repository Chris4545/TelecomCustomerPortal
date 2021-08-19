CREATE TABLE users(
    userID INT NOT NULL AUTO_INCREMENT, --Recommend removing this column and just using email, but changing sql might break the code, so left alone.
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
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
