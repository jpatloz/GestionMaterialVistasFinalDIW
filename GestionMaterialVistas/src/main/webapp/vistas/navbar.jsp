<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<nav>
	  <ul>
	   	<a class="navbar" href="registro">Registrar</a>
	   	<a class="navbar" href="login">Iniciar sesión</a>
	</ul>
</nav>
</body>

<style>
  nav {
    background-color: #333;
    height: 50px;
    display: flex;
    justify-content: center;
  }
  
  .navbar ul {
    list-style: none;
    display: flex;
    margin: 0;
    padding: 0;
  }
  
  .navbar li {
    margin: 0 10px;
  }
  
  .navbar {
    color: #fff;
    text-decoration: none;
    font-size: 18px;
  }
  
  .navbar:hover {
    text-decoration: underline;
  }
</style>
</html>