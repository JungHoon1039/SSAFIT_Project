<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List" import="com.ssafy.board.model.dto.Video"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=1000px, initial-scale=1.0 minimum-scale=1.0 maximun-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        @media all and (min-width : 1000px) {
            
        }
    </style>
    <title>SSAFIT</title>
</head>
<body>
<% List<Video> interestList= (List<Video>) request.getAttribute("interestList"); %>
<% List<Video> partList = (List<Video>) request.getAttribute("partList"); %>
    <header style = "width: 1000px;" class = "d-flex justify-content-between align-items-center m-auto">
        <img style="width:186px; height: 48px;" src="./video/data/samsung_logo.PNG" alt="samsung_logo">
        <img src="./video/data/ssafit_logo.PNG" alt="ssafit_logo">
        <div class="d-flex">
            <div class="d-flex flex-column justify-content-evenly">
                <button type="button" class="btn btn-outline-secondary m-1 mx-3">log-in</button>
                <button type="button" class="btn btn-outline-secondary m-1 mx-3">sign-up</button>
            </div>
            <i style="font-size: 50px;"class="bi bi-person-circle d-flex align-items-center m-3"></i>
        </div>
    </header>
    <main class = "d-flex flex-column m-auto align-items-center">
        <div class="input-group m-auto container justify-content-center">
            <div class="row">
                <div class="col-6 col-md-8">
                    <input type="text" class="form-control col-sm" placeholder="운동 제목 검색" aria-label="Example text with button addon" aria-describedby="button-addon1">
                </div>
                <div class="col-6 col-md-4">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon1">검색</button>
                </div>
            </div>
        </div>

        <div style = "width: 1000px;" class="m-5 border">
            <h2 class = "m-3">실시간 인기 영상</h2>
            <div id="carouselA" class="carousel slide m-3">
                <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/gMaB-fG4u4g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/swRNeYw1JkY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/54tTYO-vU2E" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/QqqZH3j_vH0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/tzN6ypk6Sps" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/u5OgcZdNbMo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/PjGcOP-TQPE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/7TLk7pscICk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/zruKSHfD7b4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselA" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselA" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div style = "width: 1000px;" class="m-3 border">
            <h2 class="m-3">운동 부위 선택</h2>
            <div class="m-3">
                <button type="button" class="btn btn-outline-info">전신</button>
                <button type="button" class="btn btn-outline-info">상체</button>
                <button type="button" class="btn btn-outline-info">하체</button>
                <button type="button" class="btn btn-outline-info">복부</button>
            </div>
            <div id="carouselB" class="carousel slide m-3">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/tzN6ypk6Sps" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/7TLk7pscICk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/zruKSHfD7b4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/gMaB-fG4u4g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/PjGcOP-TQPE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/QqqZH3j_vH0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class = "d-flex justify-content-evenly">
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/swRNeYw1JkY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/u5OgcZdNbMo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        <iframe width="300" height="200" src="https://www.youtube.com/embed/54tTYO-vU2E" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselB" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselB" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
                </button>
            </div>
            </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>