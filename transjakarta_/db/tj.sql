-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 30, 2017 at 10:44 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `transjakarta`
--

-- --------------------------------------------------------

--
-- Table structure for table `tj`
--

CREATE TABLE `tj` (
  `index` int(11) NOT NULL,
  `halte` varchar(30) NOT NULL,
  `corridor` varchar(5) NOT NULL,
  `nearby` varchar(300) DEFAULT NULL,
  `region` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tj`
--

INSERT INTO `tj` (`index`, `halte`, `corridor`, `nearby`, `region`) VALUES
(1, 'Blok M', '1', 'Blok M Square, Blok M Plaza', 'South Jakarta'),
(2, 'Masjid Agung', '1', 'Al-Azhar Pusat, Bulungan', 'South Jakarta'),
(3, 'Bundaran Senayan', '1', 'Ratu Plaza, Plaza Senayan, Senayan City, Summitmas', 'South Jakarta'),
(4, 'Gelora Bung Karno', '1', 'Fx Sudirman, Stadion Gelora Bung Karno, Kementrian Pendidikan dan Budaya', 'South Jakarta'),
(5, 'Polda', '1', 'Pacific Place, IDX, Ritz-Carlton PP, Senopati, SCBD', 'South Jakarta'),
(6, 'Bendungan Hilir', '1', 'Plaza Semanggi, Atma Jaya', 'Central Jakarta'),
(7, 'Karet', '1', 'World Trade Center, Sampoerna Strategic Square, Sona Topas Tower, Intiland Tower, Mayapada', 'Central Jakarta'),
(8, 'Dukuh Atas 1', '1', 'BNI 46', 'Central Jakarta'),
(9, 'Tosari ICBC', '1', 'Grand Indonesia, ICBC Tower, UOB Tower', 'Central Jakarta'),
(10, 'Sarinah', '1', 'Djakarta Theater, Mc Donald Sarinah', 'Central Jakarta'),
(11, 'Bank Indonesia', '1', 'Bank Indonesia, Indosurya Finance', 'Central Jakarta'),
(12, 'Monas', '1', 'Museum Nasional, Tugu Monas, Kantor Pos Jakarta', 'Central Jakarta'),
(13, 'Harmoni Central', '1', 'Duta Merlin', 'Central Jakarta'),
(14, 'Sawah Besar', '1', 'Gadjah Mada Plaza, Grand Mercure', 'Central Jakarta'),
(15, 'Mangga Besar', '1', 'Grand Paragon Hotel, Hayam Wuruk Plaza II', 'Central Jakarta'),
(16, 'Olimo', '1', 'Mercure Jakarta Kota, Apartment Mediterania', 'Central Jakarta'),
(17, 'Glodok', '1', 'Glodok Jaya, Lindeteves Trade Centre, Pasar Glodok', 'Central Jakarta'),
(18, 'Kota', '1', 'Kota Tua, Alun-Alun, Stasiun Kota, Museum Bank Indonesia, Museum Mandiri', 'Central Jakarta'),
(1, 'TU Gas', '4C', 'Kawasan Industri, Bekasi Timur', 'East Jakarta'),
(2, 'Layur', '4C', 'Tiki, Kantor Pos Pemuda, Gereja GKPS , Pulo Asem', 'East Jakarta'),
(3, 'Pemuda Rawamangun', '4C', 'Ace Hardware, Electronic City, Galeri Indosat, Bebek Kaleyo, ', 'East Jakarta'),
(4, 'Velodrome', '4C', 'Velodrome, Kayu Putih, Arion', 'East Jakarta'),
(5, 'Sunan Giri', '4C', 'Rabani, Pasar Sunan Giri, STIE, Al - Azhar 13', 'East Jakarta'),
(6, 'UNJ', '4C', 'UNJ, Graha MIR, Labschool Rawamangun,', 'East Jakarta'),
(7, 'Pramuka BPKP', '4C', 'BPKP, Apartment Green Pramuka City', 'East Jakarta'),
(8, 'Pramuka LIA', '4C', 'LIA Pramuka, Auto 2000, Is Plaza', 'East Jakarta'),
(9, 'Utan Kayu Sentral', '4C', 'Sentral Hotel', 'East Jakarta'),
(10, 'Pasar Genjing', '4C', 'Pasar Genjing. RS Evasari, Apartment Salemba, Stasiun Kramat', 'East Jakarta'),
(11, 'Matraman 2', '4C', 'Polsek Matraman, Hotel Balairung', 'Central Jakarta'),
(12, 'Proklamasi', '4C', 'Monumen Proklamasi, BPN', 'Central Jakarta'),
(13, 'Megaria', '4C', 'Metropole', 'Central Jakarta'),
(14, 'SMPN 8', '4C', 'SMPN 8, Stasiun Cikini', 'Central Jakarta'),
(15, 'Gedung Wanita', '4C', 'Gedung Wanita', 'Central Jakarta'),
(16, 'Museum Proklamasi', '4C', 'Museum Proklamasi, Taman Suropati, Masjid Agung Sunda Kelapa, Kedutaan Besar Filipina', 'Central Jakarta'),
(17, 'KPU', '4C', 'KPU', 'Central Jakarta'),
(18, 'BPD Mandiri', '4C', 'Graha Mandiri, Mandarin Oriental, BBC Indonesia, ', 'Central Jakarta'),
(19, 'Tosari', '4C', 'Grand Indonesia, ICBC Tower, UOB Tower', 'Central Jakarta'),
(20, 'Dukuh Atas 1', '4C', 'BNI 46', 'Central Jakarta'),
(21, 'Karet', '4C', 'World Trade Center, Sampoerna Strategic Square', 'Central Jakarta'),
(22, 'Bendungan Hilir', '4C', 'Plaza Semanggi, Atma Jaya', 'Central Jakarta'),
(23, 'Polda', '4C', 'Pacific Place, IDX, Ritz-Carlton PP, Senopati, SCBD', 'South Jakarta'),
(24, 'Gelora Bung Karno', '4C', 'Fx Sudirman, Stadion Gelora Bung Karno, Kementrian Pendidikan dan Kebudayaan', 'South Jakarta'),
(25, 'Bundaran Senayan', '4C', 'Ratu Plaza, Plaza Senayan, Senayan City, Summitmas', 'South Jakarta'),
(1, 'Harmoni Central', '2', 'Duta Merlin', 'Central Jakarta'),
(2, 'Monas', '2', 'Museum Nasional, Tugu Monas, Kantor Pos Jakarta', 'Central Jakarta'),
(3, 'Balaikota', '2', 'Stasiun Balai Kota, Jakarta City Hall', 'Central Jakarta'),
(4, 'Gambir 2', '2', 'Parkir IRTI Monas, Lemhanas RI', 'Central Jakarta'),
(5, 'Kwitang', '2', 'Toko Gunung Agung, Graha Marinir, GKI Kwitang', 'Central Jakarta'),
(6, 'Senen', '2', 'Pasar Senen, Plaza Atrium, Stasium Pasar Senen, ', 'Central Jakarta'),
(7, 'Galur', '2', 'Auto 2000 Cempaka Putih, ', 'Central Jakarta'),
(8, 'Rawa Selatan', '2', 'Hotel Grand Cempaka', 'Central Jakarta'),
(9, 'Ps. Cempaka Putih', '2', 'Miss Tjitjih Theater, Polsek Cempaka Putih, Acehardware Cempaka Putih, Gereja Santo Paskalis', 'Central Jakarta'),
(10, 'RS. Islam', '2', 'Universitas YARSI, Pengadilan Tinggi Jakarta', 'Central Jakarta'),
(11, 'Cempaka Timur', '2', 'ITC Cempaka Mas, Transmart Cempaka Putih', 'Central Jakarta'),
(12, 'Pedongkelan', '2', 'GBI Perintis Kemerdekaan', 'East Jakarta'),
(13, 'ASMI', '2', 'Institut Bisnis dan Multimedia ASMI, Pulomas, PT. Summarecon Agung,  ', 'East Jakarta'),
(14, 'Pulo Mas', '2', 'Apartment Tifolia, AMPED', 'East Jakarta'),
(15, 'Bermis', '2', 'Apartment Gading Icon, RS. Mediros', 'East Jakarta'),
(16, 'Pulogadung 1', '2', 'Pegangsaan Dua', 'East Jakarta'),
(1, 'Tanjung Priok', '10', 'St. Tanjung Priuk, OLIA Medical Center', 'North Jakarta'),
(2, 'Enggano', '10', 'PORT Medical Center, Puskopal Kolinlamil', 'North Jakarta'),
(3, 'Permai Koja', '10', 'Pasar Permai, Pasar Ular', 'North Jakarta'),
(4, 'Walikota Jakarta Utara', '10', 'Gelanggang Remaja Kotamadya Jakarta Utara, SMAN 13 Jakarta, Badan Pertahanan Nasional', 'North Jakarta'),
(5, 'Plumpang Pertamina', '10', 'Taman Plumpang, Pasar Pelita', 'North Jakarta'),
(6, 'Sunter Kelapa Gading', '10', 'Mall Artha Gading, AUTO 2000 Kelapa Gading', 'North Jakarta'),
(7, 'Yos Sudarso Kodamar', '10', 'SMAN 72 Jakarta, SMP Hang Tuah 3', 'North Jakarta'),
(8, 'Cempaka Mas 2', '10', 'ITC Cempaka Mas, Transmart Cempaka Putih', 'North Jakarta'),
(9, 'Cempaka Putih', '10', 'RS. Pertamina Jaya, Graha Dwi Yani', 'East Jakarta'),
(10, 'Pulomas Bypass', '10', 'Kalbis Institut, I3L, Plaza Dwima, Pulomas, RS. Omni, Apartment Pasadena', 'East Jakarta'),
(11, 'Kayu Putih Rawasari', '10', 'Rawasari,  Apartment Green Pramuka City, Graha Agape, Taman Green Pramuka', 'East Jakarta'),
(12, 'Pemuda Pramuka', '10', 'UNJ', 'East Jakarta'),
(13, 'Utan Kayu Rawamangun', '10', 'Jakarta Golf Club Rawamangun, Pura Adityajaya', 'East Jakarta'),
(14, 'Achmad Yani Bea Cukai', '10', 'Direktorat Jendral Bea dan Cukai, Stadion Bola Bea Cukai', 'East Jakarta'),
(15, 'St. Jatinegara', '10', 'Stasiun Jatinegara, SDN 1 Cipinang Besar, Vihara Orang Tua', 'East Jakarta'),
(16, 'Pedati Prumpung', '10', 'TPU Kober, TPU Prumpung, Bassura City, Pasar Gembrong, Universitas Mpu Tantular', 'East Jakarta'),
(17, 'Cipinang Kebon Nanas', '10', 'Kementrian Lingkungan Hidup dan Kehutanan, Al-Haramin Saudi Academi', 'East Jakarta'),
(18, 'Penas Kalimalang', '10', 'Institut Bisnis Nusantara', 'East Jakarta'),
(19, 'Cawang Sutoyo', '10', 'Apartment Patria Park, Park Hotel, Western Premier The Hive', 'East Jakarta'),
(20, 'Cawang UKI', '10', 'HKBP Sutoyo, Universitas Kristen Indonesia', 'East Jakarta'),
(21, 'BKN', '10', 'Badan Kepegawaian Negara, Primajasa, SMAN 14', 'East Jakarta'),
(22, 'PGC 2', '10', 'PGC, Terminal Cililitan, GKBI Kramatjati', 'East Jakarta'),
(1, 'Harmoni Central', '8', 'Duta Merlin', 'Central Jakarta'),
(2, 'RS. Sumber Waras', '8', 'Tomang Utara, Fakultas Kedokteran Universitas Trisakti, Roxy Square  ', 'Central Jakarta'),
(3, 'Grogol 1', '8', 'Universitas Trisakti ', 'West Jakarta'),
(4, 'Jelambar', '8', 'RS Royal Taruma, Rabbani Grogol, SMA Bunda Hati Kudus, PT. Citra Cinema Multimedia ', 'West Jakarta'),
(5, 'Indosiar', '8', 'Yayasan Rumah Duka Abadi, Auto 2000 Daan Mogot, PT. Hartono Raya Motor, Kantor Pos Jakarta Barat', 'West Jakarta'),
(6, 'Kedoya Green Garden', '8', 'Komplek Green Garden, Happy Puppy Green Garden, Graha Mas Arteri 2, SMA Kristen Kalam Kudus, SDN Kedoya Utara 09 ', 'West Jakarta'),
(7, 'Kedoya Assidiqqiyah', '8', 'Wang Residence, SD Kristen 11 Penabur, TMBookStore,  ', 'West Jakarta'),
(8, 'Duri Kepa', '8', 'Graha Technosoft Informatika, BNI Graha Elok Mas, Plaza Kedoya Elok, Apartment Kedoya Elok, GKI Kedoya, FedEx Duri Kepa ', 'West Jakarta'),
(9, 'Kebon Jeruk', '8', 'Indosiar Television Tower, SMPN 75, Wisma Akr, Auto Bild Indonesia ', 'West Jakarta'),
(10, 'Kelapa Dua SasakPos Pengumben', '8', 'Indomobil Nissan Datsun Kebon Jeruk, SMPN 189, SMP Al-Huda, Jalan Sasak ', 'West Jakarta'),
(11, 'Pos Pengumben', '8', 'Masjid Jami Al-Anwar, ', 'West Jakarta'),
(12, 'Permata Hijau RS. Medika', '8', 'RS Medika Permata Hijau ', 'West Jakarta'),
(13, 'Permata Hijau', '8', 'The Bellezza Shopping Arcade, Permata Hijau Residence, Halte Simprug 2   ', 'South Jakarta'),
(14, 'Simprug', '8', 'Binus School Simprug, Gedung Hyundai Indoensia ', 'South Jakarta'),
(15, 'Ps. Kebayoran Lama', '8', 'The Pakubuwono View, Pasar Kbeayoran Lama, Stasium Kebayoran  ', 'South Jakarta'),
(16, 'Kebayoran Lama Bungur', '8', 'Gandaria City Mall', 'South Jakarta'),
(17, 'Tanah Kusir Kodim', '8', 'Jalan Tanah Kusir, Jalan Cendrawasih, SPBU Shell Pondok Indah ', 'South Jakarta'),
(18, 'Pondok Indah 2', '8', 'Pondok Indah Mall 2, Masjid Raya Pondok Indah ', 'South Jakarta'),
(19, 'Pondok Indah 1', '8', 'Pondok Indah Mall 1, Pondok Indah Apartment, Pondok Indah Golf and Country Cluc ', 'South Jakarta'),
(20, 'Pondok Pinang', '8', 'Madrasah Aliyah Negri 4 Jakarta, Pondok Pinang ', 'South Jakarta'),
(21, 'Lebak Bulus', '8', 'Terminal Lebak Bulus, Carrefour Lebak Bulus, Poins Square, SMK Grafika Yayasan Lektur', 'South Jakarta'),
(1, 'Penjaringan', '12', 'Pluit Village, SMP Tarakanita 2 Pluit, GKY Pluit', 'North Jakarta'),
(2, 'Landmark Auto Plaza', '12', 'Bina Tunas Bangsa School, RS Pluit, POLSEK Penjaringan', 'North Jakarta'),
(3, 'Pakin', '12', 'SPBU Pertamina Pluit Raya, Indomaret Pakin', 'North Jakarta'),
(4, 'Gedong Panjang', '12', 'Masjid Penjaringan, Panasonic Service Center 123, Jl. Gedong Panjang I', 'North Jakarta'),
(5, 'Museum Fatahilah', '12', 'Museum Fatahilah, Taman Fatahilah, Cafe Batavia, Colosseum Jakarta, Kantorpos Mandiri Kota', 'West Jakarta'),
(6, 'Kota', '12', 'Kota Tua, Alun-Alun, Stasiun Kota, Museum Bank Indonesia', 'West Jakarta'),
(7, 'Pangeran Jayakarta', '12', 'Gereja Sion, Trans Mangga Dua, Auto 2000 Jayakarta', 'Central Jakarta'),
(8, 'Mangga Dua', '12', 'ITC Mangga Dua, Mangga Dua Mall, Pasar Pagi', 'North Jakarta'),
(9, 'Gunung Sahari Mangga Dua', '12', 'Mangga Dua Square, Hotel Neo Mangga Dua Square, Bali Jimbaran Mangga Dua', 'North Jakarta'),
(10, 'Jembatan Merah', '12', 'Pasar Jembatan Merah, The Media Hotel', 'Central Jakarta'),
(11, 'Kemayoran', '12', 'Gandhi Memorial School, RS Mitra Kemayoran', 'Central Jakarta'),
(12, 'Danau Agung', '12', 'Papa Jack Kopitiam Sunter, d\'Cost Sunter, Holiday Inn Sunter, Ruko Puri Mutiara Sunter, Food Centrum Sunter', 'North Jakarta'),
(13, 'SMP 140', '12', 'RS Satya Negara, SMAN 15 Jakarta, ACE Hardware', 'North Jakarta'),
(14, 'Sunter Karya', '12', 'Sunter Mall, Pasar Sunter, Sinotif Sunter', 'North Jakarta'),
(15, 'Sunter Boulevard Barat', '12', 'Mall Of Indonesia, Shell Kelapa Gading, Perkantoran Danau Sunter', 'North Jakarta'),
(16, 'Sunter Kelapa Gading', '12', 'Mall Artha Gading, AUTO 2000 Kelapa Gading', 'North Jakarta'),
(17, 'Plumpang Pertamina', '12', 'Taman Plumpang, Pasar Pelita', 'North Jakarta'),
(18, 'Walikota  Jakarta Utara', '12', 'Gelanggang Remaja Kotamadya Jakarta Utara, SMAN 13 Jakarta, Badan Pertahanan Nasional', 'North Jakarta'),
(19, 'Permai Koja', '12', 'Pasar Permai, Pasar Ular', 'North Jakarta'),
(20, 'Enggano', '12', 'PORT Medical Center, Puskopal Kolinlamil', 'North Jakarta'),
(21, 'Tanjung Priok', '12', 'St. Tanjung Priuk, OLIA Medical Center', 'North Jakarta');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
