
import JSONYArchivos.GestorJSONProductos;
import JSONYArchivos.JsonUsuario;
import Productos.*;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Enum.Genero;
import Enum.Suscripcion;
import Usuarios.Usuario;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();


        System.out.println
        (
            //Nole
                """
                        ╲┏━┳━━━━━━━━┓╲╲
                        ╲┃◯┃╭┻┻╮╭┻┻╮┃╲╲
                        ╲┃╮┃┃╭╮┃┃╭╮┃┃╲╲
                        ╲┃╯┃┗┻┻┛┗┻┻┻┻╮╲
                        ╲┃◯┃╭╮╰╯┏━━━┳╯╲
                        ╲┃╭┃╰┏┳┳┳┳┓◯┃╲╲
                        ╲┃╰┃◯╰┗┛┗┛╯╭┃╲╲"""
        );


        // Cliente 1
        Cliente cliente1 = new Cliente("Ana Torres", "ana.t@email.com", "555-123456", "ClaveSegura1", Suscripcion.BASICA);

// Cliente 2
        Cliente cliente2 = new Cliente("Luis Gómez", "luis.g@otrodominio.es", "555-654321", "Password2025", Suscripcion.BASICA);

// Cliente 3
        Cliente cliente3 = new Cliente("Marta Ruiz", "marta.r@ejemplo.net", "555-987654", "MartaKey$1", Suscripcion.PREMIUM);

// Cliente 4
        Cliente cliente4 = new Cliente("Javier Pérez", "javi.p@web.com", "555-234567", "Jav!erP3r", Suscripcion.BASICA);

// Cliente 5
        Cliente cliente5 = new Cliente("Sofía Castro", "sofia.c@mail.org", "555-876543", "S0f1aC@st", Suscripcion.PREMIUM);

// Cliente 6
        Cliente cliente6 = new Cliente("Ricardo Diaz", "ricardo.d@buzon.info", "555-345678", "Ric4rd0_D", Suscripcion.PREMIUM);

// Cliente 7
        Cliente cliente7 = new Cliente("Elena Flores", "elena.f@cuenta.io", "555-765432", "ElenaFlores*", Suscripcion.PREMIUM);

// Cliente 8
        Cliente cliente8 = new Cliente("Pedro Moya", "pedro.m@servidor.com", "555-456789", "P3droMoya#", Suscripcion.PREMIUM);

// Cliente 9
        Cliente cliente9 = new Cliente("Carmen Vidal", "carmen.v@correo.es", "555-678901", "C4rm3nVid", Suscripcion.BASICA);

// Cliente 10
        Cliente cliente10 = new Cliente("Andrés León", "andres.l@dominio.net", "555-012345", "AndresLe0n", Suscripcion.PREMIUM);

// Cliente 11
        Cliente cliente11 = new Cliente("Laura Ramos", "laura.r@ejemplo.com", "555-112233", "LauraR4m0s", Suscripcion.PREMIUM);

// Cliente 12
        Cliente cliente12 = new Cliente("Jorge Sanz", "jorge.s@mail.com", "555-445566", "J0rg3Sanz!", Suscripcion.PREMIUM);

// Cliente 13
        Cliente cliente13 = new Cliente("Paula Gil", "paula.g@webmail.info", "555-778899", "P4ul4Gil#", Suscripcion.BASICA);

// Cliente 14
        Cliente cliente14 = new Cliente("Héctor Vega", "hector.v@servicioweb.org", "555-009988", "HectorV3ga", Suscripcion.PREMIUM);

// Cliente 15
        Cliente cliente15 = new Cliente("Nuria Blanco", "nuria.b@mi-email.io", "555-332211", "NuriaB1anc0", Suscripcion.BASICA);



        // Administrador 1
        Administrador admin1 = new Administrador("Gerardo Salas", "gerardo.s@admin.com", "555-001122", "AdminG$2025");

// Administrador 2
        Administrador admin2 = new Administrador("Patricia Vega", "patricia.v@admin.net", "555-112233", "PatiV3ga*");

// Administrador 3
        Administrador admin3 = new Administrador("Roberto Cruz", "roberto.c@admin.es", "555-223344", "R0b3rt0C");

// Administrador 4
        Administrador admin4 = new Administrador("Silvia Nuñez", "silvia.n@admin.org", "555-334455", "SilviaN!#");

// Administrador 5
        Administrador admin5 = new Administrador("Fernando Rivas", "fernando.r@admin.info", "555-445566", "F3rn4ndoR");

// Administrador 6
        Administrador admin6 = new Administrador("Andrea Montes", "andrea.m@admin.io", "555-556677", "AndreaM*1");

// Administrador 7
        Administrador admin7 = new Administrador("Gabriel Solís", "gabriel.s@adminweb.com", "555-667788", "GabiSoli5");

// Administrador 8
        Administrador admin8 = new Administrador("Mariana Tello", "mariana.t@adminweb.net", "555-778899", "M4r1anaTello");

// Administrador 9
        Administrador admin9 = new Administrador("Esteban Polo", "esteban.p@adminweb.es", "555-889900", "Est3banPolo!");

// Administrador 10
        Administrador admin10 = new Administrador("Valeria Soto", "valeria.s@adminpro.org", "555-990011", "1");

// Administrador 11
        Administrador admin11 = new Administrador("Hugo Luna", "hugo.l@adminpro.info", "555-001100", "HugoLuna$");

// Administrador 12
        Administrador admin12 = new Administrador("Diana Mora", "diana.m@adminpro.io", "555-110011", "DianaMora#");

// Administrador 13
        Administrador admin13 = new Administrador("Óscar Gil", "oscar.g@admincorp.com", "555-220022", "0scarGil*");

// Administrador 14
        Administrador admin14 = new Administrador("Nora Rey", "nora.r@admincorp.net", "555-330033", "NoraRey2025");

// Administrador 15
        Administrador admin15 = new Administrador("Félix Cano", "felix.c@admincorp.es", "555-440044", "FelixCano!");




        // Ebook 1: FANTASIA
        Ebook ebook1 = new Ebook("El Gremio de los Magos", Genero.FANTASIA, 12.99, 2022,
                "Elara Vance", "Primera parte de una saga de magia y reinos.",
                Suscripcion.PREMIUM, 450, "EPUB", "Español");

// Ebook 2: ACCION
        Ebook ebook2 = new Ebook("Código Delta", Genero.ACCION, 15.50, 2023,
                "Agente K", "Un thriller de espionaje con persecuciones globales.",
                Suscripcion.BASICA, 320, "PDF", "Inglés");

// Ebook 3: ROMANCE
        Ebook ebook3 = new Ebook("Susurros al Amanecer", Genero.ROMANCE, 7.99, 2024,
                "Isabelle Dubois", "Una historia de amor en una isla paradisíaca.",
                Suscripcion.BASICA, 280, "EPUB", "Español");

// Ebook 4: TERROR
        Ebook ebook4 = new Ebook("La Casa en el Pantano", Genero.TERROR, 11.00, 2021,
                "Max Stone", "Una novela de horror gótico y apariciones fantasmales.",
                Suscripcion.PREMIUM, 370, "MOBI", "Inglés");

// Ebook 5: CIENCIA_FICCION
        Ebook ebook5 = new Ebook("Crónicas de Marte", Genero.CIENCIA_FICCION, 10.50, 2020,
                "Zoe Harper", "Relatos sobre la colonización y vida en el planeta rojo.",
                Suscripcion.BASICA, 610, "EPUB", "Español");

// Ebook 6: DRAMA
        Ebook ebook6 = new Ebook("El Silencio del Padre", Genero.DRAMA, 18.25, 2018,
                "Prof. Livia Rossi", "Una obra emotiva sobre secretos familiares.",
                Suscripcion.PREMIUM, 410, "PDF", "Italiano");

// Ebook 7: COMEDIA
        Ebook ebook7 = new Ebook("Manual para Sobrevivir a tu Jefe", Genero.COMEDIA, 5.99, 2024,
                "David Sharp", "Una guía hilarante para la vida en la oficina.",
                Suscripcion.BASICA, 190, "EPUB", "Español");

// Ebook 8: AVENTURA
        Ebook ebook8 = new Ebook("El Tesoro Perdido de Atahualpa", Genero.AVENTURA, 14.99, 2022,
                "Aedan MacLeod", "Una expedición en busca de una reliquia inca.",
                Suscripcion.PREMIUM, 520, "MOBI", "Inglés");

// Ebook 9: FANTASIA
        Ebook ebook9 = new Ebook("El Último Guardián", Genero.FANTASIA, 9.50, 2023,
                "Sara Lin", "Un joven descubre que tiene poderes para salvar el mundo.",
                Suscripcion.BASICA, 480, "PDF", "Español");

// Ebook 10: ROMANCE
        Ebook ebook10 = new Ebook("A Través de la Ventana", Genero.ROMANCE, 3.99, 2021,
                "Lía Marín", "Un amor forjado a través de cartas durante la pandemia.",
                Suscripcion.BASICA, 160, "EPUB", "Español");

// Ebook 11: ACCION
        Ebook ebook11 = new Ebook("Misión en Berlín", Genero.ACCION, 11.99, 2020,
                "Dr. John Smith", "Acción ininterrumpida para detener un ataque nuclear.",
                Suscripcion.PREMIUM, 350, "PDF", "Inglés");

// Ebook 12: COMEDIA
        Ebook ebook12 = new Ebook("Mi Boda con el Robot", Genero.COMEDIA, 4.50, 2024,
                "Emma Green", "Las desventuras de un humano que se casa con una IA.",
                Suscripcion.BASICA, 210, "EPUB", "Alemán");

// Ebook 13: CIENCIA_FICCION
        Ebook ebook13 = new Ebook("El Universo Fractal", Genero.CIENCIA_FICCION, 29.99, 2023,
                "Kyle Hacker", "Un tratado sobre la estructura cuántica del cosmos.",
                Suscripcion.PREMIUM, 950, "PDF", "Español");

// Ebook 14: DRAMA
        Ebook ebook14 = new Ebook("Las Cenicidas de Enero", Genero.DRAMA, 6.75, 2021,
                "Leo Funny", "Una historia conmovedora sobre la pérdida y la superación.",
                Suscripcion.BASICA, 180, "MOBI", "Francés");

// Ebook 15: AVENTURA
        Ebook ebook15 = new Ebook("El Río de las Especias", Genero.AVENTURA, 8.99, 2019,
                "Wyatt Earp Jr.", "Un viaje épico a través de junglas inexploradas.",
                Suscripcion.BASICA, 320, "EPUB", "Inglés");

        /// juegos

        Juego juego1 = new Juego("Shadow Ops: Resurgir", Genero.ACCION, 49.99, 2024,
                "Estudios Delta", "FPS militar con modos de juego tácticos.",
                Suscripcion.PREMIUM, "CPU i5, 8GB RAM, GTX 1060", true);

// Juego 2: FANTASIA (Single Player)
        Juego juego2 = new Juego("Crónicas de Aethel", Genero.FANTASIA, 59.99, 2023,
                "Pixel Dreams", "RPG de mundo abierto con un extenso lore.",
                Suscripcion.BASICA, "CPU Ryzen 5, 16GB RAM, RTX 3060", false);

// Juego 3: AVENTURA (Single Player)
        Juego juego3 = new Juego("El Legado de K'un", Genero.AVENTURA, 29.50, 2022,
                "Explora Games", "Aventura gráfica point-and-click clásica.",
                Suscripcion.BASICA, "CPU Dual Core, 4GB RAM", false);

// Juego 4: CIENCIA_FICCION (Multiplayer)
        Juego juego4 = new Juego("Galaxy Conquest 7", Genero.CIENCIA_FICCION, 69.99, 2024,
                "Starline Inc.", "Estrategia 4X espacial online masiva.",
                Suscripcion.PREMIUM, "CPU i7, 32GB RAM, RTX 4070", true);

// Juego 5: COMEDIA (Multiplayer)
        Juego juego5 = new Juego("El Caos de la Cocina", Genero.COMEDIA, 19.99, 2023,
                "Team Fun", "Simulador cooperativo de cocina basado en física.",
                Suscripcion.BASICA, "CPU i3, 8GB RAM, Tarjeta integrada", true);

// Juego 6: TERROR (Single Player)
        Juego juego6 = new Juego("Luces Rojas", Genero.TERROR, 39.99, 2022,
                "Silent Studios", "Survival horror psicológico en primera persona.",
                Suscripcion.PREMIUM, "CPU i5, 16GB RAM, GTX 1660", false);

// Juego 7: ROMANCE (Single Player)
        Juego juego7 = new Juego("Amor en el Campus", Genero.ROMANCE, 9.99, 2021,
                "Visual Novel Co.", "Novela visual interactiva de citas universitarias.",
                Suscripcion.BASICA, "Cualquier PC con Windows 7+", false);

// Juego 8: DRAMA (Single Player)
        Juego juego8 = new Juego("Las Decisiones del Destino", Genero.DRAMA, 14.50, 2020,
                "Narrative Flow", "Juego de decisiones narrativas con múltiples finales.",
                Suscripcion.BASICA, "CPU 2.0 GHz, 4GB RAM", false);

// Juego 9: ACCION (Single Player)
        Juego juego9 = new Juego("Pistolas y Sombras", Genero.ACCION, 34.00, 2023,
                "West Coast Devs", "Shooter de mundo abierto ambientado en el viejo oeste.",
                Suscripcion.PREMIUM, "CPU Ryzen 7, 16GB RAM, RTX 3070", false);

// Juego 10: FANTASIA (Multiplayer)
        Juego juego10 = new Juego("Mundo de Magia Online", Genero.FANTASIA, 15.00, 2021,
                "MMO Legends", "MMORPG de fantasía con combate en tiempo real.",
                Suscripcion.PREMIUM, "CPU i5, 8GB RAM, 10 Mbps Internet", true);

// Juego 11: AVENTURA (Multiplayer Co-op)
        Juego juego11 = new Juego("Ruinas Antiguas", Genero.AVENTURA, 22.99, 2024,
                "Co-op Kings", "Juego de rompecabezas cooperativo para 2 jugadores.",
                Suscripcion.BASICA, "CPU i3, 6GB RAM, Micrófono", true);

// Juego 12: CIENCIA_FICCION (Single Player)
        Juego juego12 = new Juego("El Último Androide", Genero.CIENCIA_FICCION, 45.00, 2023,
                "Future Tech", "Aventura cyberpunk con elementos de sigilo.",
                Suscripcion.PREMIUM, "CPU i9, 32GB RAM, SSD", false);

// Juego 13: COMEDIA (Single Player)
        Juego juego13 = new Juego("Simulador de Cabra", Genero.COMEDIA, 5.99, 2019,
                "Joke Developers", "Simulador absurdo de una cabra en la ciudad.",
                Suscripcion.BASICA  , "Cualquier PC con tarjeta de video dedicada", false);

// Juego 14: TERROR (Multiplayer Co-op)
        Juego juego14 = new Juego("Bajo la Niebla", Genero.TERROR, 25.99, 2024,
                "Scary Games", "Terror multijugador asimétrico 4v1.",
                Suscripcion.PREMIUM, "CPU i5, 8GB RAM, Conexión estable", true);

// Juego 15: ROMANCE (Multiplayer)
        Juego juego15 = new Juego("El Jardín de los Enamorados", Genero.ROMANCE, 12.00, 2022,
                "Heart Games", "Simulador de vida social y citas online.",
                Suscripcion.BASICA, "CPU 3.0 GHz, 8GB RAM, 5 Mbps Internet", true);

        /// PELICULAS

        // Película 1: ACCION
        Pelicula peli1 = new Pelicula("Furia en la Carretera", Genero.ACCION, 9.99, 2023,
                "Dir. Marc Earp", "Un ex-piloto busca venganza en la autopista.",
                Suscripcion.PREMIUM, 105.5, "PG-13");

// Película 2: FANTASIA
        Pelicula peli2 = new Pelicula("El Último Cristal", Genero.FANTASIA, 12.50, 2024,
                "Estudios Aurora", "Una épica búsqueda de un artefacto mágico.",
                Suscripcion.BASICA, 140.0, "PG");

// Película 3: TERROR
        Pelicula peli3 = new Pelicula("La Llamada Silenciosa", Genero.TERROR, 7.99, 2022,
                "Horror Films S.A.", "Un grupo de amigos es acechado por una entidad.",
                Suscripcion.PREMIUM, 95.0, "R");

// Película 4: CIENCIA_FICCION
        Pelicula peli4 = new Pelicula("Nexus: El Origen", Genero.CIENCIA_FICCION, 15.00, 2021,
                "Future Vision", "Viajes en el tiempo y paradojas cuánticas.",
                Suscripcion.PREMIUM, 128.7, "PG-13");

// Película 5: COMEDIA
        Pelicula peli5 = new Pelicula("Vacaciones Desastrosas", Genero.COMEDIA, 5.99, 2023,
                "Risas Producciones", "Una familia enfrenta un sinfín de percances en la playa.",
                Suscripcion.BASICA, 88.0, "PG");

// Película 6: DRAMA
        Pelicula peli6 = new Pelicula("El Tren de las Seis", Genero.DRAMA, 11.25, 2020,
                "Cinema Verité", "Historia de dos desconocidos con destinos cruzados.",
                Suscripcion.BASICA, 115.3, "R");

// Película 7: AVENTURA
        Pelicula peli7 = new Pelicula("El Mapa Dorado", Genero.AVENTURA, 8.50, 2024,
                "Action Studios", "Cacería de tesoros a través de selvas inexploradas.",
                Suscripcion.PREMIUM, 102.0, "PG");

// Película 8: ROMANCE
        Pelicula peli8 = new Pelicula("Bajo las Estrellas", Genero.ROMANCE, 6.99, 2023,
                "Heartbeat Films", "Dos astrónomos se enamoran mientras observan el cielo.",
                Suscripcion.BASICA, 98.5, "PG");

// Película 9: ACCION
        Pelicula peli9 = new Pelicula("Ataque Final", Genero.ACCION, 10.99, 2022,
                "Martial Arts Co.", "Un ex-agente debe proteger a un testigo clave.",
                Suscripcion.PREMIUM, 112.0, "R");

// Película 10: FANTASIA
        Pelicula peli10 = new Pelicula("El Reino Oculto", Genero.FANTASIA, 13.99, 2021,
                "Mythos Pictures", "Un portal a otro mundo se abre en la Tierra.",
                Suscripcion.BASICA, 135.2, "PG-13");

// Película 11: TERROR
        Pelicula peli11 = new Pelicula("Ecos del Manicomio", Genero.TERROR, 8.00, 2024,
                "Nightmare Productions", "Investigadores paranormales visitan un hospital abandonado.",
                Suscripcion.PREMIUM, 92.5, "R");

// Película 12: CIENCIA_FICCION
        Pelicula peli12 = new Pelicula("Inteligencia Artificial 7", Genero.CIENCIA_FICCION, 16.50, 2020,
                "Sci-Fi Nexus", "Una IA se vuelve consciente y busca la libertad.",
                Suscripcion.PREMIUM, 150.0, "PG-13");

// Película 13: COMEDIA
        Pelicula peli13 = new Pelicula("El Día de la Marmota 2.0", Genero.COMEDIA, 4.50, 2023,
                "Funny Bones Studio", "Un hombre revive el mismo día en un bucle temporal.",
                Suscripcion.BASICA, 90.0, "PG");

// Película 14: DRAMA
        Pelicula peli14 = new Pelicula("Memorias de Otoño", Genero.DRAMA, 10.00, 2019,
                "Soulful Films", "La vida de una mujer a lo largo de cinco décadas.",
                Suscripcion.BASICA, 125.7, "PG");

// Película 15: AVENTURA
        Pelicula peli15 = new Pelicula("La Montaña Perdida", Genero.AVENTURA, 9.50, 2022,
                "Explorer Team", "Un equipo de alpinistas en una expedición peligrosa.",
                Suscripcion.PREMIUM, 118.0, "PG-13");

        /// SERIES
        Serie serie1 = new Serie("Los Anillos del Destino", Genero.FANTASIA, 15.00, 2022,
                "Showrunners Épicos", "Adaptación de una novela clásica de alta fantasía.",
                Suscripcion.PREMIUM, 3, 24);

// Serie 2: ACCION
        Serie serie2 = new Serie("Agentes 47", Genero.ACCION, 9.99, 2024,
                "Stunt Productions", "Serie de espías internacionales y combates coreografiados.",
                Suscripcion.BASICA, 1, 8);

// Serie 3: COMEDIA
        Serie serie3 = new Serie("Vida de Vecinos", Genero.COMEDIA, 7.50, 2021,
                "Sitcom Factory", "Comedia sobre la convivencia en un edificio de apartamentos.",
                Suscripcion.BASICA, 5, 50);

// Serie 4: DRAMA
        Serie serie4 = new Serie("El Bufete Central", Genero.DRAMA, 12.00, 2023,
                "Legal Dramas", "Drama judicial enfocado en casos complejos de alto perfil.",
                Suscripcion.PREMIUM, 2, 18);

// Serie 5: CIENCIA_FICCION
        Serie serie5 = new Serie("Viajeros del Tiempo 3000", Genero.CIENCIA_FICCION, 14.99, 2022,
                "Future Tech TV", "Un equipo viaja al pasado para corregir errores históricos.",
                Suscripcion.PREMIUM, 4, 40);

// Serie 6: TERROR
        Serie serie6 = new Serie("El Pueblo Olvidado", Genero.TERROR, 10.50, 2023,
                "Horror Stream", "Misterios y eventos sobrenaturales en una zona rural.",
                Suscripcion.BASICA, 1, 10);

// Serie 7: ROMANCE
        Serie serie7 = new Serie("Siempre en Invierno", Genero.ROMANCE, 6.99, 2024,
                "Heart Series", "Una historia de amor entre estudiantes de arte.",
                Suscripcion.BASICA, 1, 6);

// Serie 8: AVENTURA
        Serie serie8 = new Serie("Expedición Cobre", Genero.AVENTURA, 11.99, 2022,
                "Wilderness Films", "Documental de aventuras sobre exploradores en la Patagonia.",
                Suscripcion.PREMIUM, 3, 15);

// Serie 9: FANTASIA
        Serie serie9 = new Serie("Magos de la Ciudad", Genero.FANTASIA, 13.00, 2024,
                "Urban Magic Inc.", "Fantasía urbana sobre magos que viven en secreto.",
                Suscripcion.PREMIUM, 1, 10);

// Serie 10: ACCION
        Serie serie10 = new Serie("Rescate de Élite", Genero.ACCION, 8.50, 2020,
                "Misión Studios", "Un equipo de rescate especializado en situaciones extremas.",
                Suscripcion.BASICA, 5, 65);

// Serie 11: COMEDIA
        Serie serie11 = new Serie("El Trabajo Soñado", Genero.COMEDIA, 5.00, 2021,
                "Laugh Out Loud", "Un joven consigue un trabajo absurdo en una startup.",
                Suscripcion.BASICA, 2, 18);

// Serie 12: DRAMA
        Serie serie12 = new Serie("Hospital Central 'B'", Genero.DRAMA, 11.50, 2023,
                "Medical Dramas", "Historias de doctores y pacientes en una sala de emergencias.",
                Suscripcion.PREMIUM, 1, 12);

// Serie 13: CIENCIA_FICCION
        Serie serie13 = new Serie("La Realidad Simulada", Genero.CIENCIA_FICCION, 16.00, 2024,
                "Mind Bender Studios", "Personajes descubren que viven en una simulación virtual.",
                Suscripcion.PREMIUM, 2, 16);

// Serie 14: TERROR
        Serie serie14 = new Serie("Rituales Nocturnos", Genero.TERROR, 9.00, 2022,
                "Dark Tales", "Antología de cuentos de terror cortos.",
                Suscripcion.BASICA, 3, 12);

// Serie 15: ROMANCE
        Serie serie15 = new Serie("Primavera Tardía", Genero.ROMANCE, 7.00, 2023,
                "Romance Stream", "Un romance maduro que florece en la edad adulta.",
                Suscripcion.BASICA, 1, 7);


        LinkedHashMap<Integer, Producto> productos = new LinkedHashMap<>();
        //GUARDO EBOOKS
        productos.put(ebook1.getId_Producto(), ebook1);
        productos.put(ebook2.getId_Producto(), ebook2);
        productos.put(ebook3.getId_Producto(), ebook3);
        productos.put(ebook4.getId_Producto(), ebook4);
        productos.put(ebook5.getId_Producto(), ebook5);
        productos.put(ebook6.getId_Producto(), ebook6);
        productos.put(ebook7.getId_Producto(), ebook7);
        productos.put(ebook8.getId_Producto(), ebook8);
        productos.put(ebook9.getId_Producto(), ebook9);
        productos.put(ebook10.getId_Producto(), ebook10);
        productos.put(ebook11.getId_Producto(), ebook11);
        productos.put(ebook12.getId_Producto(), ebook12);
        productos.put(ebook13.getId_Producto(), ebook13);
        productos.put(ebook14.getId_Producto(), ebook14);
        productos.put(ebook15.getId_Producto(), ebook15);

        //GUARDO PELICULAS
        productos.put(peli1.getId_Producto(), peli1);
        productos.put(peli2.getId_Producto(), peli2);
        productos.put(peli3.getId_Producto(), peli3);
        productos.put(peli4.getId_Producto(), peli4);
        productos.put(peli5.getId_Producto(), peli5);
        productos.put(peli6.getId_Producto(), peli6);
        productos.put(peli7.getId_Producto(), peli7);
        productos.put(peli8.getId_Producto(), peli8);
        productos.put(peli9.getId_Producto(), peli9);
        productos.put(peli10.getId_Producto(), peli10);
        productos.put(peli11.getId_Producto(), peli11);
        productos.put(peli12.getId_Producto(), peli12);
        productos.put(peli13.getId_Producto(), peli13);
        productos.put(peli14.getId_Producto(), peli14);
        productos.put(peli15.getId_Producto(), peli15);

        //GUARDO JUEGOS
        productos.put(juego1.getId_Producto(), juego1);
        productos.put(juego2.getId_Producto(), juego2);
        productos.put(juego3.getId_Producto(), juego3);
        productos.put(juego4.getId_Producto(), juego4);
        productos.put(juego5.getId_Producto(), juego5);
        productos.put(juego6.getId_Producto(), juego6);
        productos.put(juego7.getId_Producto(), juego7);
        productos.put(juego8.getId_Producto(), juego8);
        productos.put(juego9.getId_Producto(), juego9);
        productos.put(juego10.getId_Producto(), juego10);
        productos.put(juego11.getId_Producto(), juego11);
        productos.put(juego12.getId_Producto(), juego12);
        productos.put(juego13.getId_Producto(), juego13);
        productos.put(juego14.getId_Producto(), juego14);
        productos.put(juego15.getId_Producto(), juego15);

        //GUARDO SERIES
        productos.put(serie1.getId_Producto(), serie1);
        productos.put(serie2.getId_Producto(), serie2);
        productos.put(serie3.getId_Producto(), serie3);
        productos.put(serie4.getId_Producto(), serie4);
        productos.put(serie5.getId_Producto(), serie5);
        productos.put(serie6.getId_Producto(), serie6);
        productos.put(serie7.getId_Producto(), serie7);
        productos.put(serie8.getId_Producto(), serie8);
        productos.put(serie9.getId_Producto(), serie9);
        productos.put(serie10.getId_Producto(), serie10);
        productos.put(serie11.getId_Producto(), serie11);
        productos.put(serie12.getId_Producto(), serie12);
        productos.put(serie13.getId_Producto(), serie13);
        productos.put(serie14.getId_Producto(), serie14);
        productos.put(serie15.getId_Producto(), serie15);

        GestorJSONProductos gestorProductos = new GestorJSONProductos();
        gestorProductos.mapaProductosToArchi(productos);

        CatalogoProducto.setProductos(productos);

        /// Administradores
        Usuario.getListaUsuarios().add(admin1);
        Usuario.getListaUsuarios().add(admin2);
        Usuario.getListaUsuarios().add(admin3);
        Usuario.getListaUsuarios().add(admin4);
        Usuario.getListaUsuarios().add(admin5);
        Usuario.getListaUsuarios().add(admin6);
        Usuario.getListaUsuarios().add(admin7);
        Usuario.getListaUsuarios().add(admin8);
        Usuario.getListaUsuarios().add(admin9);
        Usuario.getListaUsuarios().add(admin10);
        Usuario.getListaUsuarios().add(admin11);
        Usuario.getListaUsuarios().add(admin12);
        Usuario.getListaUsuarios().add(admin13);
        Usuario.getListaUsuarios().add(admin14);
        Usuario.getListaUsuarios().add(admin15);

        /// Clientes
        Usuario.getListaUsuarios().add(cliente1);
        Usuario.getListaUsuarios().add(cliente2);
        Usuario.getListaUsuarios().add(cliente3);
        Usuario.getListaUsuarios().add(cliente4);
        Usuario.getListaUsuarios().add(cliente5);
        Usuario.getListaUsuarios().add(cliente6);
        Usuario.getListaUsuarios().add(cliente7);
        Usuario.getListaUsuarios().add(cliente8);
        Usuario.getListaUsuarios().add(cliente9);
        Usuario.getListaUsuarios().add(cliente10);
        Usuario.getListaUsuarios().add(cliente11);
        Usuario.getListaUsuarios().add(cliente12);
        Usuario.getListaUsuarios().add(cliente13);
        Usuario.getListaUsuarios().add(cliente14);
        Usuario.getListaUsuarios().add(cliente15);



        JsonUsuario j= new JsonUsuario();

        j.serializarListaUsuarios(Usuario.getListaUsuarios());

        j.ListaToArchivo();

        tienda.iniciar();
    }
}