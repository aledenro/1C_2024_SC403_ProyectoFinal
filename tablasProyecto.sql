drop schema if exists cookies_by_su;

drop user if exists usuario_cookies;

create database cookies_by_su;

create user 'usuario_cookies'@'%' identified by 'c0oKies_b%_sU';

grant all privileges on cookies_by_su.* to 'usuario_cookies'@'%';

flush privileges;

use cookies_by_su;

create table usuario(
	id_usuario int auto_increment not null,
	username varchar(50) not null unique,
    cedula varchar(25),
    nombre varchar(30) not null,
    apellidos varchar(50) not null,
    pais varchar(25),
    provincia varchar(25),
    canton_distrito varchar(50),
    direccion_detallada varchar(200),
    correo_electronico varchar(50) not null unique,
    contrasena varchar(512) not null,
    numero_telefono varchar(20),
    primary key(id_usuario)
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
	id_pedido int not null auto_increment,
    id_producto int not null,
    cantidad int not null,
    total double not null,
    primary key(id_pedido),
    foreign key(id_producto) references producto(id_producto)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table facturacion(
	id_facturacion int not null auto_increment,
    id_usuario int not null,
    id_pedido int not null,
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
    foreign key(id_usuario) references usuario(id_usuario),
    foreign key(id_pedido) references pedido(id_pedido)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table form_contacto(
	id_form int auto_increment not null,
	nombre varchar(30) not null,
    apellidos varchar(50) not null,
    correo_electronico varchar(50) not null,
    mensaje varchar(2000) not null,
    primary key (id_form)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table roles(
	id_rol int auto_increment not null,
    nombre_rol varchar(25) not null,
    id_usuario int,
    primary key (id_rol),
    foreign key (id_usuario) references usuario(id_usuario)
);

insert into producto(nombre_producto, descripcion, tipo, precio, ruta_imagen) values 
('Galletas Nightmare Before Christmass', 'Tamaño: 10 cm Set: 5 Galletas', 'Tamaño Completo', 12500.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fjack%20cookies.jpg?alt=media&token=69200b94-fdd4-4dfd-a805-0cb634963f19'), 
('Galletas Dinosaurios', 'Tamaño: 10 cm Set: 5 Galletas', 'Tamaño Completo', 11500.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fdinos.jpg?alt=media&token=7e1b071e-d2de-49a2-8eff-99e0c9dad6e1'),
('One Piece', 'Tamaño: 10 cm Set: 6 Galletas', 'Tamaño Completo', 15000.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fone%20piece.jpg?alt=media&token=0f13abf4-333c-4f30-be3e-6a81d51fe9c5'),
('San Valentin', 'Tamaño: 10 cm Set: 6 Galletas', 'Tamaño Completo', 11500.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fsan%20valentin.jpg?alt=media&token=843df1f6-c5c6-4dc0-bd09-f276132da7a5'),
('Halloween', 'Tamaño: 6 cm Set: 8 Galletas', 'Tamaño Mini', 10000.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fhalloween.jpg?alt=media&token=d4b41bc9-0cc8-4441-8e03-0a7e493703ff'),
('Navidad', 'Tamaño: 10 cm Set: 5 Galletas', 'Tamaño Completo', 12500.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fnavidad.jpg?alt=media&token=5eccb2e5-17f0-427c-8bc8-c2b93a63e91d'),
('Pasito', 'Galletas Grandes: Tamaño: 8 cm, Pequeñas: 5 cm Set: 4 Galletas', 'Set Combinado', 8000.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fpasito.jpg?alt=media&token=543cc34d-3ae3-46ab-b72e-80aa88824ab7'),
('Cascanueces', 'Tamaño: 10 cm Set: 3 Galletas', 'Tamaño Completo', 6000.00, 'https://firebasestorage.googleapis.com/v0/b/cookies-by-su.appspot.com/o/cookies_by_Su%2Fproductos%2Fcascanueces.jpg?alt=media&token=2e2df4c5-3f62-4324-82cb-521014f26495')
; 

use cookies_by_su;

delete from usuario where id_usuario = 1;

insert into usuario(username, nombre, apellidos, correo_electronico, contrasena)
select 'admin', 'Admin', 'Admin', 'admin@gmail.com', '$2a$12$gsyP3Rt7jGTkIpO/233y3u9ibJgxJjyndoUOrnfUzCEMHzcii2Rpi' union
select 'test', 'Test', 'Test', 'test@gmail.com', '$2a$12$NedoCwQi.ToQNf/VSqUHv.IyiPXx0aMQ5edCYkBhPugUwhUvZTeJa';

insert into roles(nombre_rol, id_usuario)
select 'ROLE_ADMIN', 1 union
select 'ROLE_USER', 1 union
select 'ROLE_USER', 2

