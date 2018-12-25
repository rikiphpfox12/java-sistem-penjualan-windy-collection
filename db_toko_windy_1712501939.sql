# Host: localhost  (Version 5.5.5-10.1.32-MariaDB)
# Date: 2018-12-25 10:06:55
# Generator: MySQL-Front 6.1  (Build 1.23)


#
# Structure for table "barang"
#

DROP TABLE IF EXISTS `barang`;
CREATE TABLE `barang` (
  `KdBrg` varchar(6) NOT NULL DEFAULT '',
  `NmBrg` varchar(50) DEFAULT NULL,
  `Ukuran` varchar(10) DEFAULT NULL,
  `HargaBrg` int(6) DEFAULT NULL,
  `Stok` int(3) DEFAULT NULL,
  `KdKategori` int(3) DEFAULT NULL,
  PRIMARY KEY (`KdBrg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "barang"
#

INSERT INTO `barang` VALUES ('B101','Windy Tunik [S]','S',50000,11,1),('B102','Windy Tunik [M]','M',50000,12,1),('B103','Jodhie Tunik [S]','S',50000,12,1),('B104','Jodhie Tunik [M]','M',50000,11,1),('B105','Jodhie Tunik [L]','L',50000,11,1),('B201','Gamis Syari Pesta [S]','S',80000,12,2),('B202','Gamis Syari Pesta [M]','M',80000,10,2),('B203','Gamis Baloteli [S]','S',90000,12,2),('B204','Gamis Baloteli [M]','M',90000,9,2);

#
# Structure for table "buktipesan"
#

DROP TABLE IF EXISTS `buktipesan`;
CREATE TABLE `buktipesan` (
  `NoPesan` varchar(7) NOT NULL DEFAULT '',
  `TglPesan` date DEFAULT NULL,
  `KdPlg` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`NoPesan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "buktipesan"
#

INSERT INTO `buktipesan` VALUES ('BP00001','2018-12-25',NULL),('BP00002','2018-12-25',NULL),('BP00003','2018-12-25',NULL),('BP00004','2018-12-25',NULL),('BP00005','2018-12-25',NULL),('BP00006','2018-12-25',NULL),('BP00007','2018-12-25',NULL);

#
# Structure for table "detilpesan"
#

DROP TABLE IF EXISTS `detilpesan`;
CREATE TABLE `detilpesan` (
  `NoPesan` varchar(7) NOT NULL DEFAULT '',
  `KdBrg` varchar(6) NOT NULL DEFAULT '0',
  `HrgPesan` int(6) DEFAULT NULL,
  `JmlPesan` int(3) DEFAULT NULL,
  PRIMARY KEY (`NoPesan`,`KdBrg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "detilpesan"
#

INSERT INTO `detilpesan` VALUES ('BP00001','B204',90000,1),('BP00002','B104',50000,1),('BP00002','B202',80000,1),('BP00003','B202',80000,1),('BP00004','B204',90000,1),('BP00005','B204',90000,1),('BP00006','B105',50000,1),('BP00007','B101',50000,1);

#
# Structure for table "kategori"
#

DROP TABLE IF EXISTS `kategori`;
CREATE TABLE `kategori` (
  `KdKategori` varchar(3) NOT NULL DEFAULT '',
  `NmKategori` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`KdKategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "kategori"
#

INSERT INTO `kategori` VALUES ('1','Tunik'),('2','Gamis'),('3','Atasan');

#
# Structure for table "pelanggan"
#

DROP TABLE IF EXISTS `pelanggan`;
CREATE TABLE `pelanggan` (
  `KdPlg` varchar(6) NOT NULL DEFAULT '',
  `NmPlg` varchar(50) DEFAULT NULL,
  `AlamatPlg` varchar(50) DEFAULT NULL,
  `TelpPlg` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`KdPlg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "pelanggan"
#


#
# Structure for table "suplier"
#

DROP TABLE IF EXISTS `suplier`;
CREATE TABLE `suplier` (
  `kdsuplier` int(11) NOT NULL AUTO_INCREMENT,
  `nmsuplier` varchar(50) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `telpsuplier` int(11) DEFAULT NULL,
  PRIMARY KEY (`kdsuplier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "suplier"
#

INSERT INTO `suplier` VALUES (1,'Arani Agent','Jl. Dago, Bandung\n',123123123),(2,'Produsen Gamis Indonesia','Jakarta\n',123123),(3,'Butik Syari','Bandung\n',123123);
