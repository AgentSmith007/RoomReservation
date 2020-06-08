-- test.`user` definition

CREATE TABLE `user` (
`id` binary(255) NOT NULL,
`email` varchar(255) NOT NULL,
`login` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`user_name` varchar(255) DEFAULT NULL,
`phone` varchar(100) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- test.room definition

CREATE TABLE `room` (
`id` binary(255) NOT NULL,
`reserved` bit(1) DEFAULT NULL,
`room_number` int NOT NULL,
`type` varchar(255) NOT NULL,
`hotel_id` binary(255) DEFAULT NULL,
`visitor_id` binary(255) DEFAULT NULL,
`room_id` binary(255) DEFAULT NULL,
`description` varchar(300) DEFAULT NULL,
`price` mediumblob,
PRIMARY KEY (`id`),
KEY `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`),
KEY `FKaqdcu61a2h9xmug3jgkba31e6` (`visitor_id`),
KEY `FKqiql9p8bwg2b5sod0rmmk7cw7` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- test.hotel definition

CREATE TABLE `hotel` (
`id` binary(255) NOT NULL,
`title` varchar(255) DEFAULT NULL,
`description` varchar(300) DEFAULT NULL,
`email` varchar(100) NOT NULL,
`phone` varchar(100) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;