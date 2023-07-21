<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="/public/images/logo-ico-small.svg"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
    <title>Book Shop</title>
</head>
<style>


    html *::-webkit-scrollbar {
        border-radius: 0;
        width: 8px;
    }

    html *::-webkit-scrollbar {
        border-radius: 0;
        width: 8px;
    }

    html *::-webkit-scrollbar-thumb {
        background-color: rgba(0, 0, 0, .15);
    }

    html *::-webkit-scrollbar-thumb {
        background-color: rgba(0, 0, 0, .15);
    }

    html *::-webkit-scrollbar-track {
        border-radius: 0;
        background-color: rgba(0, 0, 0, 0);
    }

    html *::-webkit-scrollbar-track {
        border-radius: 0;
        background-color: rgba(0, 0, 0, 0);
    }
</style>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg row shadow-sm fixed-top px-3"
         style="background-color: #0a3d62">
        <div class="container-fluid">
            <a class="navbar-brand" href="/home"> <img alt="logo"
                                                   src="https://media.istockphoto.com/id/1315110986/vi/vec-to/l%C6%B0u-tr%E1%BB%AF-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-ph%C3%A1c-th%E1%BA%A3o-n%C3%A9t-c%C3%B3-th%E1%BB%83-ch%E1%BB%89nh-s%E1%BB%ADa-%C4%91%C6%B0%E1%BB%A3c-c%C3%A1ch-ly-tr%C3%AAn-h%C3%ACnh-minh-h%E1%BB%8Da-vector.jpg?s=2048x2048&w=is&k=20&c=AX40xiMyHP8Gqj8Yl0I-u4VfeZmArtKj0H79nyypQcg="
                                                   width="80" height="80">
            </a>
            <button class="navbar-toggler " type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false"
                    aria-label="Toggle navigation">
                <i class="fa-solid fa-bars fs-2"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link text-white"
                                            aria-current="page" href="/home">Trang Chủ</a></li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link text-white"
                                            aria-current="page" href="/home">login</a></li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link text-white"
                                            aria-current="page" href="/home">Quên MK</a></li>
                </ul>

            </div>


            <div class="d-flex px-4">

                    </a>
                        <ul class="dropdown-menu" aria-labelledby="dropAccount"
                            style="top: auto; left: auto;">
                            <sec:authorize access="!isAuthenticated()">
                                <li><a class="dropdown-item" href="/login">Login</a></li>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <li><a class="dropdown-item" href="/logout">Logout</a></li>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('1') and isAuthenticated()">
                                <li><a class="dropdown-item" href="/admin">Manage Users</a></li>
                            </sec:authorize>
                        </ul>

                    <li class="nav-item"><a class="nav-link text-white"
                                            aria-current="page" href="/user/carts"> <i
                            class="fa-solid fa-cart-shopping fs-4 position-relative"> <c:if
                            test="${ countCart >0}">
										<span
                                                class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                                                style="font-size: 0.5em"> ${ countCart } <span
                                                class="visually-hidden">unread messages</span>
										</span>
                    </c:if>
                    </i>
                    </a></li>

                </ul>
            </div>
        </div>
    </nav>
    <%-- Slider --%>
    <div class="row" style="margin-top: 120px">
        <div id="carouselExampleInterval" class="carousel slide"
             data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                    <img src="https://media.istockphoto.com/id/1222457390/vi/anh/doanh-nghi%E1%BB%87p-nh%E1%BB%8F-owener-c%E1%BB%95-phi%E1%BA%BFu-h%C3%ACnh-%E1%BA%A3nh.jpg?s=2048x2048&w=is&k=20&c=yQ8i-5pD0PBYWxWBDRT8G50mKxG-XCbuNd1ezUe4yvc="
                         class="d-block w-100 rounded" alt="sale" style="height: 550px">
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                    <img src="https://media.istockphoto.com/id/623475948/vi/anh/ch%C3%A2n-dung-ch%E1%BB%A7-nh%C3%A2n-vui-v%E1%BA%BB-trong-c%E1%BB%ADa-h%C3%A0ng-qu%E1%BA%A7n-%C3%A1o-nh%C3%ACn-v%C3%A0o-m%C3%A1y-%E1%BA%A3nh.jpg?s=612x612&w=0&k=20&c=QVk7eolowsQ0wZgzYk1JEt8j1bk5c_UJaW_ZZMSsCPw="
                         class="d-block w-100 rounded" alt="sale" style="height: 550px">
                </div>
                <div class="carousel-item">
                    <img src="https://media.istockphoto.com/id/1068322538/vi/anh/ng%C6%B0%E1%BB%9Di-b%C3%A1n-tr%E1%BB%B1c-tuy%E1%BA%BFn-ch%E1%BB%A5p-%E1%BA%A3nh-s%E1%BA%A3n-ph%E1%BA%A9m-%C4%91%E1%BB%83-t%E1%BA%A3i-l%C3%AAn-trang-web.jpg?s=612x612&w=0&k=20&c=a2Y07iYoapOGyuGqYH7lUaqhCU7QfXNSzgoCRIiC7Pw="
                         class="d-block w-100 rounded" alt="sale" style="height: 550px">
                </div>
            </div>
            <button class="carousel-control-prev" type="button"
                    data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button"
                    data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <%-- Main --%>

    <%-- Footer --%>
    <div class="row mt-5 p-4" style="background-color: #0a3d62">
        <div class="col-4 text-center">
            <img alt="logo"
                 src="https://media.istockphoto.com/id/1315110986/vi/vec-to/l%C6%B0u-tr%E1%BB%AF-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-ph%C3%A1c-th%E1%BA%A3o-n%C3%A9t-c%C3%B3-th%E1%BB%83-ch%E1%BB%89nh-s%E1%BB%ADa-%C4%91%C6%B0%E1%BB%A3c-c%C3%A1ch-ly-tr%C3%AAn-h%C3%ACnh-minh-h%E1%BB%8Da-vector.jpg?s=2048x2048&w=is&k=20&c=AX40xiMyHP8Gqj8Yl0I-u4VfeZmArtKj0H79nyypQcg="
                 height="100px" width="100">
            <p style="color: #dcdde1">FPT Polytechnic Shopping</p>
        </div>
        <div class="col-4">
            <p class="text-white fw-bold">INFORMATION</p>
            <p style="color: #dcdde1">About Us</p>
            <p style="color: #dcdde1">Delivery Information</p>
            <p style="color: #dcdde1">Privacy Policy</p>
            <p style="color: #dcdde1">Terms and Conditions</p>
            <p style="color: #dcdde1">Returns</p>
            <p style="color: #dcdde1">Gift Certificates</p>
        </div>
        <div class="col-4">
            <p class="text-white fw-bold">CONTACT US</p>
            <form action="">
                <label for="exampleFormControlInput1" class="form-label"
                       style="color: #dcdde1">Email address</label> <input type="email"
                                                                           class="form-control"
                                                                           id="exampleFormControlInput1"
                                                                           placeholder="name@example.com">
                <button type="button" class="btn btn-primary w-100 mt-2">Send</button>
            </form>
        </div>
        <hr>
        <p class="text-center text-white fw-bold">Nhóm 1</p>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>