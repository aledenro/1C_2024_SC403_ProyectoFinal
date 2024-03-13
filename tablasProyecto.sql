drop schema if exists cookies_by_su;

drop user if exists usuario_cookies;

create database cookies_by_su;

create user 'usuario_cookies'@'%' identified by 'c0oKies_b%_sU';

grant all privileges on cookies_by_su.* to 'usuario_cookies'@'%';

flush privileges;

use cookies_by_su;

create table usuario(
	username varchar(50) not null unique,
    cedula varchar(25) not null,
    nombre varchar(30) not null,
    apellidos varchar(50) not null,
    pais varchar(25) not null,
    provincia varchar(25) not null,
    canton_distrito varchar(50) not null,
    direccion_detallada varchar(200) not null,
    correo_electronico varchar(50) not null unique,
    contrasena varchar(25) not null,
    rol varchar(25) not null,
    numero_telefono varchar(20) not null,
    primary key(username)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table producto(
	id_producto int not null auto_increment,
    nombre_producto varchar(50) not null,
    descripcion varchar(500) not null,
    tipo varchar(50) not null,
    precio double not null,
    ruta_imagen varchar(1024),
    primary key(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table pedido_personalizado(
	id_pedidop int not null auto_increment,
    nombre varchar(30) not null,
    apellidos varchar(50) not null,
    correo_electronico varchar(50) not null,
    numero_telefono varchar(20) not null,
    fecha_preliminar date not null,
    descripcion varchar(500) not null,
    ruta_imagen varchar(1024),
    primary key(id_pedidop)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table pedido(
	num_pedido int not null auto_increment,
    id_producto int not null,
    cantidad int not null,
    total double not null,
    primary key(num_pedido),
    foreign key(id_producto) references producto(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table facturacion(
	id_facturacion int not null auto_increment,
    username varchar(50) not null,
    num_pedido int not null,
    direccion_detallada varchar(350) not null,
	fecha_pedido date not null,
    fecha_entrega date not null,
    forma_pago varchar(50) not null,
    cancelado boolean not null,
    entregado boolean not null,
    subtotal double,
    iva double,
    total_iva double,
    primary key(id_facturacion),
    foreign key(username) references usuario(username),
    foreign key(num_pedido) references pedido(num_pedido)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table form_contacto(
	nombre varchar(30) not null,
    apellidos varchar(50) not null,
    correo_electronico varchar(50) not null,
    mensaje varchar(2000) not null
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into producto(nombre_producto, descripcion, tipo, precio, ruta_imagen)
select 'Galletas Nightmare Before Christmass', 'Tamaño: 10 cm <br> Set: 5 Galletas', 'Tamaño Completo', 12500.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fjack%20cookies.jpg?alt=media&token=69200b94-fdd4-4dfd-a805-0cb634963f19'; 

use cookies_by_su;
select p1_0.id_producto,p1_0.descripcion,p1_0.nombre_producto,p1_0.precio,p1_0.ruta_imagen,p1_0.tipo from producto p1_0 where p1_0.id_producto=1