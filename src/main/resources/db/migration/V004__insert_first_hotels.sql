SET datestyle = dmy;

INSERT INTO hotels (hotel_name, hotel_location, room, price, check_in_interval, check_out_interval, rating, breakfast, wifi_connection, private_parking, minibar, latitude, longitude)
VALUES
    ('Hotel Transilvania', 'Cluj-Napoca', 'Double', 250, '01-11-2024', '25-11-2024', 4, true, true, true, true, 46.77257487675571, 23.58927290234772),
    ('Hotel Athenee Palace Hilton', 'Bucuresti', 'Double', 580, '01-12-2024', '15-12-2024', 5, true, true, true, true, 44.440970595252665, 26.095706827129625),
    ('Hotel Grand  Continental', 'Bucuresti', 'Single', 260, '02-11-2024', '24-11-2024', 4, true, true, true, false, 44.437319966009085, 26.102269493861563),
    ('Hotel Bella Muzica', 'Brasov', 'Single', 220, '01-09-2024', '20-09-2024', 3, false, true, false, true, 45.641866307785925, 25.58799633557951),
    ('Hotel Articus', 'Craiova', 'Double', 310, '05-10-2024', '13-10-2024', 3, true, false, false, true, 44.33063657454258, 23.77368586441806),
    ('Hotel Ramada Parc', 'Bucuresti', 'Double', 580, '02-08-2024', '13-08-2024', 4, true, false, false, true, 44.480228700000005, 26.063260735581938),
    ('Hotel Ibis', 'Timisoara', 'Single', 240, '01-09-2024', '03-09-2024', 3, true, true, false, true, 45.75722541923983, 21.21983790689371),
    ('Hotel Kronwell', 'Brasov', 'Single', 320, '12-11-2024', '14-11-2024', 5, true, true, false, false, 45.660304069579354, 25.61477889671953),
    ('Hotel Mercure', 'Sibiu', 'Single', 250, '20-10-2024', '22-10-2024', 4, true, false, false, true, 45.783808688741836, 24.13863525599799),
    ('Hotel JW Marriott', 'Bucuresti', 'Single', 340, '04-08-2024', '27-08-2024', 5, true, false, false, true, 44.42563494490865, 26.076893677564694),
    ('Hotel Continental Forum', 'Sibiu', 'Single', 320, '06-07-2024', '24-07-2024', 4, true, false, false, true, 45.792246994332004, 24.147914396727227),
    ('Hotel Radisson Blu', 'Bucuresti', 'Double', 680, '05-09-2024', '08-09-2024', 5, true, true, false, true, 44.44138761122658, 26.0944377389782),
    ('Hotel City Plaza', 'Cluj-Napoca', 'Single', 450, '04-10-2024', '15-10-2024', 3, true, true, false, true, 46.76976374556397, 23.58418321349245),
    ('Hotel Golden Tulip', 'Bucuresti', 'Double', 580, '01-11-2024', '03-11-2024', 4, true, true, false, true, 44.44543950580276, 26.09150332364012),
    ('Hotel Hilton', 'Sibiu', 'Double', 340, '05-08-2024', '12-08-2024', 5, true, true, true, true, 45.76049157108031, 24.126940967889457),
    ('Hotel Green House', 'Craiova', 'Double', 250, '11-09-2024', '23-09-2024', 3, true, false, false, true, 44.31437169440887, 23.79969933897105),
    ('Hotel Crowne Plaza', 'Bucuresti', 'Single', 420, '03-06-2024', '17-06-2024', 4, true, false, false, true, 44.47944497107495, 26.064484725487905),
    ('Hotel Aro Palace', 'Brasov', 'Double', 580, '10-07-2024', '15-07-2024', 3, true, false, false, false, 45.64510227000618, 25.590545896718652),
    ('Hotel Novotel', 'Bucuresti', 'Single', 540, '05-09-2024', '07-09-2024', 4, true, true, false, true, 44.43686897107575, 26.097154196649594),
    ('Hotel Golden Tulip Ana Tower', 'Sibiu', 'Double', 200, '15-10-2024', '18-10-2024', 4, true, true, true, false, 45.786888534142896, 24.147250567890957),
    ('Hotel Premier', 'Sibiu', 'Single', 260, '03-08-2024', '23-08-2024', 3, true, false, false, true, 45.783409571080924, 24.163168796726655),
    ('Hotel Sheraton', 'Bucuresti', 'Double', 350, '12-07-2024', '15-07-2024', 5, true, true, false, true, 44.4466373117286, 26.099315896650136),
    ('Hotel Europeca', 'Craiova', 'Single', 210, '11-02-2024', '19-02-2024', 4, true, false, false, true, 44.325586021003076, 23.80375983059937),
    ('Hotel Capitol', 'Bucuresti', 'Double', 580, '01-10-2024', '25-10-2024', 4, true, true, false, true, 44.43545735351986, 26.097830196649486),
    ('Hotel InterContinental', 'Bucuresti', 'Double', 260, '01-10-2024', '15-10-2024', 5, true, true, true, true, 44.43698860414168, 26.097888153057568),
    ('Hotel Opera Plaza', 'Cluj-Napoca', 'Double', 350, '02-07-2024', '15-07-2024', 3, true, false, false, true, 46.768916080992675, 23.600457669301147),
    ('Hotel RIN Central', 'Bucuresti', 'Double', 580, '02-08-2024', '13-08-2024', 4, true, false, false, true, 44.42976526593938, 26.119917906718097),
    ('Hotel Ramada', 'Sibiu', 'Single', 540, '05-09-2024', '07-09-2024', 4, true, false, false, true, 45.790952652066146, 24.147796296727066),
    ('Hotel Hilton Garden Inn', 'Bucharest', 'Single', 450, '12-10-2024', '15-10-2024', 5, true, true, true, true, 44.43309628103324, 26.100674689156364),
    ('Hotel Ramada', 'Craiova', 'Double', 680, '05-09-2024', '08-09-2024', 4, true, true, false, true, 44.3213602175464, 23.796474576650034);
