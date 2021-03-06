# FUNDAMENTOS_DE_PROGRAMACION_2
Desarrollo de	un	programa	que	simule	parte	del	funcionamiento	de	un	sistema	de	gestión	de	compra	y	venta	de	productos	de	una	tienda.	El	funcionamiento	normal	de	este	tipo	de	sistemas	se	detalla	a	continuación:

Supongamos	que	llega	un	empleado	delante	del	ordenador	y	lo	primero	que	hace	es	autenticarse	(login	y	password)	en	el	sistema.	Una	vez	autenticado,	el	empleado	puede	realizar	las	siguientes	tareas:	modificación	de	los	productos	en	stock,	la	realización	de	pedidos	según	las	peticiones	de	un	cliente	o	la	modificación	de	su	contraseña.	

Así	pues,	tenemos	un	sistema	principal	que	es	el	encargado	de	interactuar	con	el	empleado	a	través	de	ciertos	menús	y	comunicarle	con	los	subsistemas	correspondientes	dependiendo	de	la	operación	que	desee	realizar.	El	sistema	principal	consta	de	dos	subsistemas:	el	sistema	de	gestión	de	empleados	y	el	sistema	de	gestión	de	pedidos.	
El	sistema	de	gestión	de	empleados	se	encargará	de	cargar	desde	sendos	archivos	de	texto	plano	todos	los	empleados	de	la	empresa,	los	productos	y	las	ofertas,	cuando	comience	a	funcionar	el	programa.		Si	la	ubicación	de	los	ficheros	no	es	correcta	se	le	permitirá	dos	veces	cambiarla	y	si	sigue	sin	ser	correcta	se	terminará.	

La	función	principal	de	dicho	subsistema	es	la	comprobación	de	que	el	login		y	password	de	cada	empleado	que	entra	en	el	sistema	son	correctos.	

En	el	caso	de	que	el	usuario	introduzca	el	login	o	el	password	de	forma	errónea	se	lanzará	una	excepción	que	avisará	al	sistema	de	que	se	ha	producido	dicho	error.	El	sistema	tendrá	que	capturar	dicho	error	y	gestionarlo	de	tal	manera	que	sean	solicitados	los	datos	de	nuevo	al	usuario.		Si	se	comete	el	error	3	veces		se	acabará	l	ejecución	del	programa.	

Las	excepciones	en	nuestro	sistema	tienen	dos	propiedades	un	código	de	error	(valor	entero)	y	mensaje	descriptivo	del	error.	Cuando	se	haya	introducido	mal	el	login	la	excepción	tendrá	como	código		111	y	mensaje	de	error	“Error.	Login	incorrecto”,	mientras	que	cuando	el	fallo	sea	en	el	password,	el	código	será	222	y	el	mensaje	será	“Error.	Password	incorrecto”.	

Introduzca	codigo	de	empleado	
1234	Introduzca	password	de	empleado	55	Excepcion	#	222:	Error.	Password	incorrecto	Por	favor	introduzca	un	password	correcto	Introduzca	codigo	de	empleado	1236	Introduzca	password	de	empleado	pozno	Excepcion	#	111:	Error.	Login	incorrecto	
	
	
Cada	empleado	se	describe	con	las	siguientes	características:	código	de	acceso	(valor	entero	único),	nombre	del	usuario	(cadena	de	texto),	password	(cadena	de	texto),	nivel	(valor	entero)	y	productividad	(dato	real).	La	productividad	representa	un	plus	económico	que	gana	el	empleado	cada	vez	que	un	cliente	completa	un	pedido	de	forma	exitosa.	Inicialmente	cada	empleado	tiene	una	productividad	de	0€.

El	cálculo	de	la	productividad	depende	del	turno	que	lleven.	Cada	vez	que	se	completa	un	pedido,	cada	empleado	recibe	una	gratificación:	el	empleado	de	nivel	1	recibe	1€	más,	el	de	nivel	2	recibe	2€	y	el	de	nivel	3,	3€.	

Los	empleados	pueden	trabajar	de	noche	o	de	día.	Los	empleados	nocturnos	tienen	un	plus	de	nocturnidad	que	es	un	porcentaje	del	precio	de	cada	pedido	realizado.	Es	decir,	si	un	empleado	de	nivel	2	con	plus	de	nocturnidad	de	4.5%	atiende	un	pedido	de	100€,	a	su	productividad	se	le	sumará	2€	+	100€*0.045.	

Mientras,	los	empleados	diurnos,	al	tener	un	turno	mejor	de	ventas,	reciben	la	misma	gratificación	que	los	nocturnos	(1€,	2€	o	3€	según	el	nivel),	pero	no	tienen	plus	de	nocturnidad.	Además,	tienen	asociada	un	porcentaje	de	retención	por	cada	gratificación	recibida	que	depende	del	nivel.	A	los	empleados	de	nivel	1,	al	tener	una	gratificación	muy	baja,	no	se	les	hará	retención.	Mientras	que	un	empleado	de	nivel	3	con	retención	del	4%	por	ejemplo,	que	atienda	un	pedido	de	x€	se	le	aplicará		a	su	productividad	una	retención	de	3€	-	3*0.04€,	es	decir,	la	gratificación	menos	un	4%	de	esa	gratificación	(los	x€	que	costó	el	pedido	no	son	relevantes).	A	los	empleados	de	nivel	2	solo	se	les	aplicará	una	retención	similar	a	los	del	nivel	3	cuando	el	pedido	sea	superior	a	300€,	si	fuera	inferior	no	se	les	aplicará	ninguna	retención.	Todos	los	valores	antes	comentados	sobre	los	máximos	de	las	compras	(300€)	y	las	gratificaciones	(1€,	2€,	3€)	son	valores	que	dependen	mucho	de	la	situación	financiera	de	la	empresa,	por	lo	que,	es	conveniente	tenerlo	fácilmente	localizables	en	una	interfaz	para	poder	modificarlos	cuando	sea	necesario.	
