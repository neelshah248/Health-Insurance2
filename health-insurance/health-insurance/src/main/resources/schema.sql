DROP TABLE IF EXISTS `enrollee`;
CREATE TABLE `enrollee` (
  `id` int AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `activationStatus` BOOLEAN,
  `birthDate` varchar(50) DEFAULT NULL,
  `phone` int,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `dependent`;
CREATE TABLE `dependent` (
  `id` int AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `birthDate` varchar(50) DEFAULT NULL,
  `enrollee_id` int,
  PRIMARY KEY (`id`),
  FOREIGN KEY (enrollee_id) REFERENCES enrollee(id)
);

