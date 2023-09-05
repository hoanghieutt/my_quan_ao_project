<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <!-- Sử dụng Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!-- Hoặc sử dụng Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
<%--    <link href="style.css" rel="stylesheet">--%>
    <style>
        /* Thêm màu sắc và hiệu ứng tùy chỉnh */

        body {
            background-color: #f8f9fa;
            /* Màu nền */
        }

        .card {
            border: 2px solid #343a40;
            /* Màu đường viền cho thẻ */
            border-radius: 10px;
            /* Bo góc thẻ */
            background-color: #ffffff;
            /* Màu nền cho thẻ */
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            /* Hiệu ứng bóng đổ */
        }

        .card-title {
            color: #343a40;
            /* Màu chữ cho tiêu đề thẻ */
        }

        .card-text {
            color: #6c757d;
            /* Màu chữ cho nội dung thẻ */
            font-size: 24px;
            /* Cỡ chữ lớn hơn */
        }

        /* Hiệu ứng khi di chuột vào thẻ */
        .card:hover {
            transform: scale(1.05);
            /* Phóng to thẻ */
            transition: transform 0.3s ease-in-out;
        }
    </style>
</head>

<body>

<div class="container mt-5">

    <div class="row">
        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Tổng doanh thu
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${tongDoanhThu}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Tổng đơn hàng
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${tongDonHang}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fa fa-shopping-cart fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Earnings (Annual) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                Sản phẩm bán chạy nhất
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${maSanPhamBanChayNhat}</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">Đã bán: ${soLuongDaBan}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Tasks Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tổng số lượng sản phẩm
                            </div>
                            <div class="row no-gutters align-items-center">
                                <div class="col-auto">
                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${totalQuantity}</div>
                                </div>
                                <div class="col">
                                    <div class="progress progress-sm mr-2">
                                        <div class="progress-bar bg-info" role="progressbar" style="width: 50%"
                                             aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
        Biểu đồ số lượng sản phẩm
    </button>
    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">
        Biểu đồ doanh thu
    </button>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <div>
                <button id="barChartButton" class="btn btn-success">Biểu đồ Bar</button>
                <button id="lineChartButton" class="btn btn-danger">Biểu đồ Line</button>
                <button id="pieChartButton" class="btn btn-warning">Biểu đồ Pie</button>
            </div>
            <canvas id="productChart" width="400" height="200"></canvas>
        </div>
    </div>

    <div class="collapse" id="collapseExample1">
        <div class="card card-body">
            <div>
                <div class="container mt-5">
                    <button id="barChartButton1" class="btn btn-success">Biểu đồ Bar</button>
                    <button id="lineChartButton1" class="btn btn-danger">Biểu đồ Line</button>
                    <button id="pieChartButton1" class="btn btn-warning">Biểu đồ Pie</button>
                    <canvas id="productChart1" width="400" height="200"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>

    <script>
        $(document).ready(function() {
            var currentChart;

            function changeChartType(chartType) {
                if (currentChart) {
                    currentChart.destroy();
                }

                var ctx = document.getElementById('productChart').getContext('2d');
                var chartData = {
                    labels: productNames,
                    datasets: [{
                        label: 'Số lượng sản phẩm',
                        data: productQuantities,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                };

                if (chartType === 'bar') {
                    currentChart = new Chart(ctx, {
                        type: 'bar',
                        data: chartData,
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true,
                                    max: 50
                                }
                            },
                            plugins: {
                                legend: {
                                    display: false
                                },
                                datalabels: {
                                    anchor: 'end',
                                    align: 'top',
                                }
                            },
                            barPercentage: 0.5,
                            categoryPercentage: 0.7,
                        }
                    });
                } else if (chartType === 'line') {
                    currentChart = new Chart(ctx, {
                        type: 'line',
                        data: chartData,
                        options: {
                            scales: {
                                y: {
                                    beginAtZero: true,
                                    max: 50
                                }
                            },
                            plugins: {
                                legend: {
                                    display: false
                                },
                                datalabels: {
                                    anchor: 'end',
                                    align: 'top',
                                }
                            }
                        }
                    });
                } else if (chartType === 'pie') {
                    currentChart = new Chart(ctx, {
                        type: 'pie',
                        data: {
                            labels: productNames,
                            datasets: [{
                                data: productQuantities,
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255, 99, 132, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(153, 102, 255, 1)',
                                    'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            plugins: {
                                legend: {
                                    display: true,
                                    position: 'right'
                                }
                            },

                            aspectRatio: 3
                        }
                    });
                }
            }

            var productNames = [];
            var productQuantities = [];

            $.getJSON('/chiTietSanPham/thongke-data', function(data) {
                data.forEach(function(product) {
                    productNames.push(product.sanpham.tensp);
                    productQuantities.push(product.soLuong);
                });

                changeChartType('bar'); // Hiển thị biểu đồ bar mặc định khi trang được tải

                $('#barChartButton').click(function() {
                    changeChartType('bar');
                });

                $('#lineChartButton').click(function() {
                    changeChartType('line');
                });

                $('#pieChartButton').click(function() {
                    changeChartType('pie');
                });
            });
        });
    </script>
<script>
    $(document).ready(function() {
        var currentChart;

        function changeChartType(chartType) {
            if (currentChart) {
                currentChart.destroy();
            }

            var ctx = document.getElementById('productChart1').getContext('2d');
            var chartData = {
                labels: productNames,
                datasets: [{
                    label: 'Số lượng sản phẩm',
                    data: productTongTien,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            };

            if (chartType === 'bar') {
                currentChart = new Chart(ctx, {
                    type: 'bar',
                    data: chartData,
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                            }
                        },
                        plugins: {
                            legend: {
                                display: false
                            },
                            datalabels: {
                                anchor: 'end',
                                align: 'top',
                            }
                        },
                        barPercentage: 0.5,
                        categoryPercentage: 0.7,
                    }
                });
            } else if (chartType === 'line') {
                currentChart = new Chart(ctx, {
                    type: 'line',
                    data: chartData,
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true,
                            }
                        },
                        plugins: {
                            legend: {
                                display: false
                            },
                            datalabels: {
                                anchor: 'end',
                                align: 'top',
                            }
                        }
                    }
                });
            } else if (chartType === 'pie') {
                currentChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: productNames,
                        datasets: [{
                            data: productTongTien,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        plugins: {
                            legend: {
                                display: true,
                                position: 'right'
                            }
                        },

                        aspectRatio: 3
                    }
                });
            }
        }

        var productNames = [];
        var productTongTien = [];

        $.getJSON('/thongke-data-hoadon', function(data) {
            data.forEach(function(product) {
                productNames.push(product.ngayTao)
                productTongTien.push(product.gia * product.soLuong);
            });

            changeChartType('bar'); // Hiển thị biểu đồ bar mặc định khi trang được tải

            $('#barChartButton1').click(function() {
                changeChartType('bar');
            });

            $('#lineChartButton1').click(function() {
                changeChartType('line');
            });

            $('#pieChartButton1').click(function() {
                changeChartType('pie');
            });
        });
    });
</script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
    <script>
        // Đây là một số giả định về dữ liệu (có thể thay đổi theo dự án thực tế)
        const totalRevenue = 50000; // Tổng doanh thu
        const totalQuantity = 100; // Tổng số lượng hàng
        const bestSellingItem = "Item A"; // Hàng bán chạy nhất

        // Cập nhật dữ liệu trên trang
        $(document).ready(function () {
            $("#totalRevenue").text("$" + totalRevenue);
            $("#totalQuantity").text(totalQuantity);
            $("#bestSellingItem").text(bestSellingItem);
        });

    </script>
</body>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</html>