create table ninja(
	id int primary key auto_increment,
    nombre varchar(30) not null,
    rango enum("bajo", "medio", "alto") not null,
    aldea varchar(20) not null
);

create table mision(
	id int primary key auto_increment,
    descripcion varchar(100),
    rango enum("bajo", "medio", "alto") not null,
    recompensa enum("Y","N")
);

create table habilidad(
	id int primary key auto_increment,
    id_ninja int,
	nombre varchar(30) not null,
    descripcion varchar(100),
    foreign key(id_ninja) references ninja(id)
);

create table mision_ninja(
	id int primary key auto_increment,
    id_ninja int,
    id_mision int,
    fecha_inicio date,
    fecha_fin date,
    foreign key(id_ninja) references ninja(id),
    foreign key(id_mision) references mision(id)
);