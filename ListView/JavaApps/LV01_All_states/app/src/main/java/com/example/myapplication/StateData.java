package com.example.myapplication;

public class StateData {

    final String[] states = {
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
            "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
            "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh",
            "Dadra and Nagar Haveli and Daman and Diu", "Lakshadweep", "Delhi", "Puducherry"
    };

    final String[] capitals = {
            "Amaravati", "Itanagar", "Dispur", "Patna", "Raipur", "Panaji", "Gandhinagar", "Chandigarh",
            "Shimla", "Ranchi", "Bengaluru", "Thiruvananthapuram", "Bhopal", "Mumbai", "Imphal", "Shillong",
            "Aizawl", "Kohima", "Bhubaneswar", "Chandigarh", "Jaipur", "Gangtok", "Chennai", "Hyderabad",
            "Agartala", "Lucknow", "Dehradun", "Kolkata", "Port Blair", "Chandigarh", "Daman", "Kavaratti",
            "New Delhi", "Puducherry"
    };

    final String[] areas = {
            "162,970 sq km", "83,743 sq km", "78,438 sq km", "94,163 sq km", "135,194 sq km", "3,702 sq km",
            "196,024 sq km", "44,212 sq km", "55,673 sq km", "79,714 sq km", "191,791 sq km", "38,863 sq km",
            "308,252 sq km", "307,713 sq km", "22,327 sq km", "22,720 sq km", "21,081 sq km", "16,579 sq km",
            "155,707 sq km", "50,362 sq km", "342,239 sq km", "7,096 sq km", "130,058 sq km", "112,077 sq km",
            "10,486 sq km", "243,290 sq km", "53,483 sq km", "88,752 sq km", "9,251 sq km", "114 sq km",
            "603 sq km", "2,240 sq km", "1,484 sq km", "1,483 sq km"
    };

    final String[] populations = {
            "49,506,799", "1,383,727", "35,607,034", "124,799,926", "29,032,389", "1,457,723", "60,439,692",
            "28,204,708", "7,485,968", "40,322,916", "67,562,686", "35,122,966", "85,358,494", "123,144,223",
            "3,097,714", "3,291,823", "1,097,206", "1,978,502", "46,984,721", "30,037,593", "68,548,437",
            "6,702,619", "72,147,030", "39,592,972", "4,051,845", "237,882,725", "20,424,833", "91,376,152",
            "1,117,000", "419,978", "1,586,956", "1,648,427", "2,057,865", "1,414,050"
    };


    final static String[] stateDescriptions = {
            "Andhra Pradesh: A cultural gem along the coast, Andhra Pradesh is known for its rich heritage and classical dance forms. Telugu, the language of warmth, resonates in conversations.",

            "Arunachal Pradesh: Nestled in the eastern Himalayas, Arunachal Pradesh is a vibrant canvas of indigenous traditions and lush green valleys. Diverse tribes speak in the tapestry of tribal languages.",

            "Assam: Enchanting festivals like Bihu echo through Assam, where the Brahmaputra River flows gracefully. Assamese, a language of camaraderie, is spoken amidst tea plantations.",

            "Bihar: Steeped in history, Bihar unfolds ancient wonders amid the Gangetic plains. The Ganges River, a lifeline, mirrors in diverse agricultural practices and conversations in Hindi and Maithili.",

            "Chhattisgarh: A tapestry of tribal culture, Chhattisgarh unfolds its story in forested hills and fertile plains. Chhattisgarhi, a language of harmony, echoes through vibrant folk dances.",

            "Goa: Infused with Portuguese charm, Goa is a coastal paradise where Konkani whispers through the Western Ghats. The music of the sea harmonizes with the state's vibrant cultural tapestry.",

            "Gujarat: Gujarat, a historical tapestry, unfolds architectural marvels in the Rann of Kutch. Diverse landscapes, from deserts to Gir Forest, echo tales spoken in the language of Gujarati.",

            "Haryana: Amidst golden fields, Haryana boasts a rich history and agricultural heart. Conversations in Hindi resonate warmth, creating a cultural symphony in this northern state.",

            "Himachal Pradesh: Serenity unfolds in Himachal Pradesh, where scenic landscapes and Himalayan ranges paint a picturesque canvas. Hindi, the language of the mountains, whispers through the breeze.",

            "Jharkhand: Jharkhand, adorned with tribal traditions, reveals its cultural richness in the Chota Nagpur Plateau. Dense forests resonate with Hindi, narrating tales of resilience and unity.",

            "Karnataka: The IT hub, Karnataka, weaves tales of innovation amid diverse landscapes. Kannada, the language of diversity, resonates through historical wonders and the Western Ghats.",

            "Kerala: Kerala, cradled by backwaters, weaves traditions amidst lush greenery. Malayalam, a language of poetry, echoes in the vibrant culture of this southwestern paradise.",

            "Madhya Pradesh: The heart of India, Madhya Pradesh, unfolds historical wonders and wildlife sanctuaries. Hindi, a language of stories, harmonizes with the diverse landscapes of this central state.",

            "Maharashtra: Maharashtra, an economic powerhouse, embraces cultural diversity amidst the Western Ghats. Marathi, the language of vibrancy, resonates through historical echoes and modern narratives.",

            "Manipur: Rich cultural tapestries unfold in Manipur against scenic landscapes, and Manipuri dance tells tales of tradition. The Loktak Lake mirrors the poetic beauty of this northeastern gem.",

            "Meghalaya: In Meghalaya, abundant rainfall paints a picturesque landscape. Khasi, the language of tranquility, echoes amidst rolling hills and cultural richness.",

            "Mizoram: A canvas of diverse tribal culture unfolds in Mizoram, amidst scenic beauty. Mizo, a language of unity, resonates in this northeastern state where tradition and nature intertwine.",

            "Nagaland: Nagaland, a tapestry of tribal diversity, paints a picturesque landscape. English, a language of unity, narrates stories of resilience and communal harmony.",

            "Odisha: Temples and monuments come to life in Odisha, a coastal state where the Odia language whispers tales of history. The Bay of Bengal embraces a land steeped in cultural richness.",

            "Punjab: Vibrant Sikh culture dances to the rhythm of fertile plains in Punjab. Punjabi, a language of celebration, resonates in the echoes of festivities and fields of gold.",

            "Rajasthan: Rajasthan, a tapestry of rich history, unfolds against the backdrop of desert landscapes. Historical forts and palaces echo tales of valor, narrated in the language of Hindi.",

            "Sikkim: Sikkim, a jewel in the Himalayas, is adorned with diverse flora and fauna. Nepali, a language of unity, resonates in this state where tradition and nature intertwine.",

            "Tamil Nadu: Temples rise like poetry in Tamil Nadu, where classical arts dance amidst diverse landscapes. Tamil, a language of melody, echoes through time and tradition in this southern haven.",

            "Telangana: Telangana, the IT and business hub, is a cultural kaleidoscope. Telugu, a language of innovation, narrates stories of growth and progress in this dynamic state.",

            "Tripura: Cultural diversity blooms in Tripura against scenic landscapes. Bengali and Kokborok languages weave tales of unity and harmony in this northeastern gem.",

            "Uttar Pradesh: Historical landmarks dot the landscape of Uttar Pradesh, where the Ganges River flows. Hindi, a language of tradition, narrates the tales of resilience and cultural richness in this populous state.",

            "Uttarakhand: In Uttarakhand, the Himalayan state, scenic landscapes unfold tales of spirituality. Hindi, a language of tranquility, resonates in the ancient traditions and natural beauty of this northern haven.",

            "West Bengal: West Bengal, a cultural melting pot, unfolds against the canvas of historical landmarks. Bengali, a language of passion, resonates in the cultural richness that stretches from the Himalayas to the Bay of Bengal.",

            "Andaman and Nicobar Islands: The tropical beauty of the Andaman and Nicobar Islands is mirrored in diverse marine life. Hindi, a language of serenity, narrates tales of pristine beaches and coral wonders in this island paradise.",

            "Chandigarh: Chandigarh, a planned city, resonates with the warmth of Punjabi and Hindi languages. Amidst modernity and tradition, the cultural heartbeat of Chandigarh echoes in architectural marvels.",

            "Dadra and Nagar Haveli and Daman and Diu: Portuguese influence adorns this Union Territory. Gujarati, a language of fusion, narrates stories of cultural richness and coastal beauty.",

            "Lakshadweep: Coral islands of Lakshadweep whisper tales of tropical beauty. Malayalam, a language of the heart, resonates in the gentle waves and pristine shores of this archipelago paradise.",

            "Delhi: In the National Capital Territory of Delhi, historical landmarks stand amidst diverse cultures. Hindi, a language of unity, narrates the tales of a city where tradition meets modernity.",

            "Puducherry: French influence graces the coastal beauty of Puducherry. Tamil and French languages weave tales of tranquility, where colonial charm meets the serenity of the Bay of Bengal."
    };

}
