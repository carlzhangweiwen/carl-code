<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("basePath", basePath);
%>
<!doctype html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, minimal-ui" />
<meta name="format-detection" content="telephone=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>全部商品</title>
<base href="<%=basePath%>">
<link href="resources/idb/css/bass.css" rel="stylesheet" type="text/css">
<link href="resources/idb/css/goods.css" rel="stylesheet" type="text/css">
<body>
<div class="l-body">
	<header class="l-header">
			<article class="header">
				<a href="javascript:void(0);" class="l-back">
					<i class="l-ico-back"></i>
				</a>
				<h1>全部商品</h1>
			</article>
	</header>
	<!-- 一级导航 -->
	<div class="l-tab">
		<ul>
			<li><a href="#">首页</a></li>
			<li><a href="#" class="cur">全部商品</a></li>
			<li><a href="lately">最新揭晓</a></li>
			<li><a href="#">个人中心</a></li>
		</ul>
	</div>
	<!-- 二级导航 -->
	<article style="position:relative">
		<div style="position:absolute; width:100%;">
			<div class="l-tab-type">
				<ul>
					<li>
						<a href="">人气
						</a>
					</li>
					<li>
						<a href="">最新
						</a>
					</li>
					<li class="up">
						<a href="">剩余
						<i class="ico ico-arrow"></i>
						</a>
					</li>
					<li class="down">
						<a href="">总需
						<i class="ico ico-arrow"></i>
						</a>
					</li>
				</ul>
			</div>
			<div class="l-goods">
				<ul class="l-goods-list"> 
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
						<li class="l-goods-list-item">
							<div class="l-goods">
								<div class="l-goods-photo">
									<a>
										<img src="resources/idb/img/xj.png">
									</a>
								</div>
								<div class="l-goods-info">
									<p class="l-goods-title">
										<a href="">中国黄金 9999投资金元宝 100g</a>
									</p>
									<div class="l-goods-bar">
										<p class="wrap">
											<span class="lad">
												<cite class="ys"></cite>
											</span>
										</p>
										<ul class="text">
											<li>开奖进度<i>23%</i></li>
											<li>剩余<i>23</i></li>
										</ul>
									</div>
								</div>
							</div>
						</li>
				</ul>		
				<div class="ladding">
					<img src="./img/loading.gif" alt="">
					加载中....
				</div>
			</div>
		</div>
	</article>
</div>

</body>
</html>