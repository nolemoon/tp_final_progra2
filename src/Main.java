import Exceptions.ProductoNoEncontradoException;
import Productos.Ebook;
import Productos.Tienda;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Enum.Genero;
import Enum.Suscripcion;

public class Main {
    public static void main(String[] args) throws ProductoNoEncontradoException {
        Tienda tienda = new Tienda();


        System.out.println
        (
            //Nole
                "╲┏━┳━━━━━━━━┓╲╲\n" +
                "╲┃◯┃╭┻┻╮╭┻┻╮┃╲╲\n" +
                "╲┃╮┃┃╭╮┃┃╭╮┃┃╲╲\n" +
                "╲┃╯┃┗┻┻┛┗┻┻┻┻╮╲\n" +
                "╲┃◯┃╭╮╰╯┏━━━┳╯╲\n" +
                "╲┃╭┃╰┏┳┳┳┳┓◯┃╲╲\n" +
                "╲┃╰┃◯╰┗┛┗┛╯╭┃╲╲"
        );


        // Cliente 1
        Cliente cliente1 = new Cliente("Ana Torres", "ana.t@email.com", "555-123456", "ClaveSegura1");

// Cliente 2
        Cliente cliente2 = new Cliente("Luis Gómez", "luis.g@otrodominio.es", "555-654321", "Password2025");

// Cliente 3
        Cliente cliente3 = new Cliente("Marta Ruiz", "marta.r@ejemplo.net", "555-987654", "MartaKey$1");

// Cliente 4
        Cliente cliente4 = new Cliente("Javier Pérez", "javi.p@web.com", "555-234567", "Jav!erP3r");

// Cliente 5
        Cliente cliente5 = new Cliente("Sofía Castro", "sofia.c@mail.org", "555-876543", "S0f1aC@st");

// Cliente 6
        Cliente cliente6 = new Cliente("Ricardo Diaz", "ricardo.d@buzon.info", "555-345678", "Ric4rd0_D");

// Cliente 7
        Cliente cliente7 = new Cliente("Elena Flores", "elena.f@cuenta.io", "555-765432", "ElenaFlores*");

// Cliente 8
        Cliente cliente8 = new Cliente("Pedro Moya", "pedro.m@servidor.com", "555-456789", "P3droMoya#");

// Cliente 9
        Cliente cliente9 = new Cliente("Carmen Vidal", "carmen.v@correo.es", "555-678901", "C4rm3nVid");

// Cliente 10
        Cliente cliente10 = new Cliente("Andrés León", "andres.l@dominio.net", "555-012345", "AndresLe0n");

// Cliente 11
        Cliente cliente11 = new Cliente("Laura Ramos", "laura.r@ejemplo.com", "555-112233", "LauraR4m0s");

// Cliente 12
        Cliente cliente12 = new Cliente("Jorge Sanz", "jorge.s@mail.com", "555-445566", "J0rg3Sanz!");

// Cliente 13
        Cliente cliente13 = new Cliente("Paula Gil", "paula.g@webmail.info", "555-778899", "P4ul4Gil#");

// Cliente 14
        Cliente cliente14 = new Cliente("Héctor Vega", "hector.v@servicioweb.org", "555-009988", "HectorV3ga");

// Cliente 15
        Cliente cliente15 = new Cliente("Nuria Blanco", "nuria.b@mi-email.io", "555-332211", "NuriaB1anc0");



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
        Administrador admin10 = new Administrador("Valeria Soto", "valeria.s@adminpro.org", "555-990011", "ValeriaSoto*");

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

/// Ebook
        admin1.alta(ebook1);
        admin2.alta(ebook2);
        admin3.alta(ebook3);
        admin4.alta(ebook4);
        admin5.alta(ebook5);
        admin6.alta(ebook6);
        admin7.alta(ebook7);
        admin8.alta(ebook8);
        admin9.alta(ebook9);
        admin10.alta(ebook10);
        admin11.alta(ebook11);
        admin12.alta(ebook12);
        admin13.alta(ebook13);
        admin14.alta(ebook14);
        admin15.alta(ebook15);

        /// Juegos


        /// Administradores
        admin1.getListaUsuarios().add(admin1);
        admin2.getListaUsuarios().add(admin2);
        admin3.getListaUsuarios().add(admin3);
        admin4.getListaUsuarios().add(admin4);
        admin5.getListaUsuarios().add(admin5);
        admin6.getListaUsuarios().add(admin6);
        admin7.getListaUsuarios().add(admin7);
        admin8.getListaUsuarios().add(admin8);
        admin9.getListaUsuarios().add(admin9);
        admin10.getListaUsuarios().add(admin10);
        admin11.getListaUsuarios().add(admin11);
        admin12.getListaUsuarios().add(admin12);
        admin13.getListaUsuarios().add(admin13);
        admin14.getListaUsuarios().add(admin14);
        admin15.getListaUsuarios().add(admin15);

        /// Clientes
        cliente1.getListaUsuarios().add(cliente1);
        cliente2.getListaUsuarios().add(cliente2);
        cliente3.getListaUsuarios().add(cliente3);
        cliente4.getListaUsuarios().add(cliente4);
        cliente5.getListaUsuarios().add(cliente5);
        cliente6.getListaUsuarios().add(cliente6);
        cliente7.getListaUsuarios().add(cliente7);
        cliente8.getListaUsuarios().add(cliente8);
        cliente9.getListaUsuarios().add(cliente9);
        cliente10.getListaUsuarios().add(cliente10);
        cliente11.getListaUsuarios().add(cliente11);
        cliente12.getListaUsuarios().add(cliente12);
        cliente13.getListaUsuarios().add(cliente13);
        cliente14.getListaUsuarios().add(cliente14);
        cliente15.getListaUsuarios().add(cliente15);

    }
}