DROP TABLE IF EXISTS `enrollee`;
CREATE TABLE `enrollee` (
  `id` int AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `activationStatus` BOOLEAN,
  `bDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `dependent`;
CREATE TABLE `dependent` (
  `id` int AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `bDate` varchar(50) DEFAULT NULL,
  `enrollee_id` int,
  PRIMARY KEY (`id`),
  FOREIGN KEY (enrollee_id) REFERENCES enrollee(id)
);