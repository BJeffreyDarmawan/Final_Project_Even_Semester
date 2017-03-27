-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 24, 2017 at 12:51 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tj`
--

CREATE TABLE `tj` (
  `index` int(11) NOT NULL,
  `halte` varchar(30) NOT NULL,
  `corridor` varchar(5) NOT NULL,
  `nearby` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tj`
--

INSERT INTO `tj` (`index`, `halte`, `corridor`, `nearby`) VALUES
(1, 'Blok M', '1', 'Blok M Square, Blok M Plaza'),
(2, 'Masjid Agung', '1', 'Al-Azhar Pusat, Bulungan'),
(3, 'Bundaran Senayan', '1', 'Ratu Plaza, Plaza Senayan, Senayan City, Summitmas'),
(4, 'Gelora Bung Karno', '1', 'Fx Sudirman, Stadion Gelora Bung Karno, Kementrian Pendidikan dan Budaya'),
(5, 'Polda Metro Jaya', '1', 'Pacific Place, IDX, Ritz-Carlton PP, Senopati, SCBD'),
(6, 'Bendungan Hilir', '1', 'Plaza Semanggi, Atma Jaya'),
(7, 'Karet', '1', 'World Trade Center, Sampoerna Strategic Square, Sona Topas Tower, Intiland Tower, Mayapada'),
(8, 'Dukuh Atas 1', '1', 'BNI 46'),
(9, 'Tosari ICBC', '1', 'Grand Indonesia, ICBC Tower, UOB Tower'),
(10, 'Sarinah', '1', 'Djakarta Theater, Mc Donald Sarinah'),
(11, 'Bank Indonesia', '1', 'Bank Indonesia, Indosurya Finance'),
(12, 'Monas', '1', 'Museum Nasional, Tugu Monas, Kantor Pos Jakarta'),
(13, 'Harmoni Central', '1', 'Duta Merlin'),
(14, 'Sawah Besar', '1', 'Gadjah Mada Plaza, Grand Mercure'),
(15, 'Mangga Besar', '1', 'Grand Paragon Hotel, Hayam Wuruk Plaza II'),
(16, 'Olimo', '1', 'Mercure Jakarta Kota, Apartment Mediterania'),
(17, 'Glodok', '1', 'Glodok Jaya, Lindeteves Trade Centre, Pasar Glodok'),
(18, 'Kota', '1', 'Kota Tua, Alun-Alun, Stasiun Kota, Museum Bank Indonesia, Museum Mandiri'),
(1, 'TU Gas', '4C', 'Kawasan Industri, Bekasi Timur'),
(2, 'Layur', '4C', 'Tiki, Kantor Pos Pemuda, Gereja GKPS , Pulo Asem'),
(3, 'Pemuda Rawamangun', '4C', 'Ace Hardware, Electronic City, Galeri Indosat, Bebek Kaleyo, '),
(4, 'Velodrome', '4C', 'Velodrome, Kayu Putih, Arion'),
(5, 'Sunan Giri', '4C', 'Rabani, Pasar Sunan Giri, STIE, Al - Azhar 13'),
(6, 'UNJ', '4C', 'UNJ, Graha MIR, Labschool Rawamangun,'),
(7, 'Pramuka BPKP', '4C', 'BPKP, Apartment Green Pramuka City'),
(8, 'Pramuka LIA', '4C', 'LIA Pramuka, Auto 2000, Is Plaza'),
(9, 'Utan Kayu Sentral', '4C', 'Sentral Hotel'),
(10, 'Pasar Genjing', '4C', 'Pasar Genjing. RS Evasari, Apartment Salemba, Stasiun Kramat'),
(11, 'Matraman 2', '4C', 'Polsek Matraman, Hotel Balairung'),
(12, 'Proklamasi', '4C', 'Monumen Proklamasi, BPN'),
(13, 'Megaria', '4C', 'Metropole'),
(14, 'SMPN 8', '4C', 'SMPN 8, Stasiun Cikini'),
(15, 'Gedung Wanita', '4C', 'Gedung Wanita'),
(16, 'Museum Proklamasi', '4C', 'Museum Proklamasi, Taman Suropati, Masjid Agung Sunda Kelapa, Kedutaan Besar Filipina'),
(17, 'KPU', '4C', 'KPU'),
(18, 'BPD Mandiri', '4C', 'Graha Mandiri, Mandarin Oriental, BBC Indonesia, '),
(19, 'Tosari', '4C', 'Grand Indonesia, ICBC Tower, UOB Tower'),
(20, 'Dukuh Atas 1', '4C', 'BNI 46'),
(21, 'Karet', '4C', 'World Trade Center, Sampoerna Strategic Square'),
(22, 'Bendungan Hilir', '4C', 'Plaza Semanggi, Atma Jaya'),
(23, 'Polda', '4C', 'Pacific Place, IDX, Ritz-Carlton PP, Senopati, SCBD'),
(24, 'Gelora Bung Karno', '4C', 'Fx Sudirman, Stadion Gelora Bung Karno, Kementrian Pendidikan dan Kebudayaan'),
(25, 'Bundaran Senayan', '4C', 'Ratu Plaza, Plaza Senayan, Senayan City, Summitmas'),
(1, 'Harmoni Central', '2', 'Duta Merlin'),
(2, 'Monas', '2', 'Museum Nasional, Tugu Monas, Kantor Pos Jakarta'),
(3, 'Balaikota', '2', 'Stasiun Balai Kota, Jakarta City Hall'),
(4, 'Gambir 2', '2', 'Parkir IRTI Monas, Lemhanas RI'),
(5, 'Kwitang', '2', 'Toko Gunung Agung, Graha Marinir, GKI Kwitang'),
(6, 'Senen', '2', 'Pasar Senen, Plaza Atrium, Stasium Pasar Senen, '),
(7, 'Galur', '2', 'Auto 2000 Cempaka Putih, '),
(8, 'Rawa Selatan', '2', 'Hotel Grand Cempaka'),
(9, 'Ps. Cempaka Putih', '2', 'Miss Tjitjih Theater, Polsek Cempaka Putih, Acehardware Cempaka Putih, Gereja Santo Paskalis'),
(10, 'RS. Islam', '2', 'Universitas YARSI, Pengadilan Tinggi Jakarta'),
(11, 'Cempaka Timur', '2', 'ITC Cempaka Mas, Transmart Cempaka Putih'),
(12, 'Pedongkelan', '2', 'GBI Perintis Kemerdekaan'),
(13, 'ASMI', '2', 'Institut Bisnis dan Multimedia ASMI, Pulomas, PT. Summarecon Agung,  '),
(14, 'Pulo Mas', '2', 'Apartment Tifolia, AMPED'),
(15, 'Bermis', '2', 'Apartment Gading Icon, RS. Mediros'),
(16, 'Pulogadung 1', '2', 'Pegangsaan Dua'),
(1, 'Tanjung Priok', '10', 'St. Tanjung Priuk, OLIA Medical Center'),
(2, 'Enggano', '10', 'PORT Medical Center, Puskopal Kolinlamil'),
(3, 'Permai Koja', '10', 'Pasar Permai, Pasar Ular'),
(4, 'Walikota Jakarta Utara', '10', 'Gelanggang Remaja Kotamadya Jakarta Utara, SMAN 13 Jakarta, Badan Pertahanan Nasional'),
(5, 'Plumpang Pertamina', '10', 'Taman Plumpang, Pasar Pelita'),
(6, 'Sunter Kelapa Gading', '10', 'Mall Of Indonesia, Mall Artha Gading, Perkantoran Danau Sunter'),
(7, 'Yos Sudarso Kodamar', '10', 'SMAN 72 Jakarta, SMP Hang Tuah 3'),
(8, 'Cempaka Mas 2', '10', 'ITC Cempaka Mas, Transmart Cempaka Putih'),
(9, 'Cempaka Putih', '10', 'RS. Pertamina Jaya, Graha Dwi Yani'),
(10, 'Pulomas Bypass', '10', 'Kalbis Institut, I3L, Plaza Dwima, Pulomas, RS. Omni, Apartment Pasadena'),
(11, 'Kayu Putih Rawasari', '10', 'Rawasari,  Apartment Green Pramuka City, Graha Agape, Taman Green Pramuka'),
(12, 'Pemuda Pramuka', '10', 'UNJ'),
(13, 'Utan Kayu Rawamangun', '10', 'Jakarta Golf Club Rawamangun, Pura Adityajaya'),
(14, 'Achmad Yani Bea Cukai', '10', 'Direktorat Jendral Bea dan Cukai, Stadion Bola Bea Cukai'),
(15, 'St. Jatinegara', '10', 'Stasiun Jatinegara, SDN 1 Cipinang Besar, Vihara Orang Tua'),
(16, 'Pedati Prumpung', '10', 'TPU Kober, TPU Prumpung, Bassura City, Pasar Gembrong, Universitas Mpu Tantular'),
(17, 'Cipinang Kebon Nanas', '10', 'Kementrian Lingkungan Hidup dan Kehutanan, Al-Haramin Saudi Academi'),
(18, 'Penas Kalimalang', '10', 'Institut Bisnis Nusantara'),
(19, 'Cawang Sutoyo', '10', 'Apartment Patria Park, Park Hotel, Western Premier The Hive'),
(20, 'Cawang UKI', '10', 'HKBP Sutoyo, Universitas Kristen Indonesia'),
(21, 'BKN', '10', 'Badan Kepegawaian Negara, Primajasa, SMAN 14'),
(22, 'PGC 2', '10', 'PGC, Terminal Cililitan, GKBI Kramatjati');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
