<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>体检中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>css/index.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="<%=path%>css/bjqs.css">
<script src="<%=path%>js/jquery-1.7.2.min.js"></script>
<script src="<%=path%>js/bjqs-1.3.js"></script>
<script src="<%=path%>js/jquery.secret-source.min.js"></script>
<script>
	jQuery(function($) {

		$('.secret-source').secretSource({
			includeTag : false
		});
	});
</script>
<script class="secret-source">
	jQuery(document).ready(function($) {
		$('#banner-fade').bjqs({
			height : 400,
			width : 1000,
			responsive : true
		});

	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="clear"></div>
	<div class="body-content">
		<div class="wrap">
			<div class="slider">
				<div id="container">
					<jsp:include page="carousel.jsp" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="sidebar-1">
				<h3>常见体检问题及解答</h3>
				<div class="grid-list">
					<h4>问题一：身体很好，没有任何不舒服，需要做健康检查吗？</h4>
					<p>答：没有不舒服并不代表健康，许多疾病在初期和萌芽状态都无自觉症状，外观上也看不出生病的样子，定期的健康检查，可及早查出潜在的致病因子或功能异常情形，达到早期发现、早期治疗的目的</p>
				</div>
				<div class="grid-list">
					<h4>问题二：年轻力壮，需要做体检吗？</h4>
					<p>答：年轻力壮者，不论男女都必须做定期体检。疾病发生的原因是由于遗传、环境及生活习惯等因素而渐进发生，与年龄不存在因果关系，通过科学仪器的正确检测，可有效检出疾病的存在，愈早检出，治疗效果愈好</p>
				</div>
				<div class="grid-list">
					<h4>问题三：近来身体自觉很差，体检却查不出病来，这是什么原因？</h4>
					<p>答：很可能您正处于亚健康状态较严重的阶段。但进行亚健康调理前，最后进行一次较细致的全面检查比较合适，以避免疾病漏诊</p>
				</div>
				<div class="grid-list">&nbsp;
				</div>
				<div class="grid-list">
					<h4>问题四：身体不舒服时，是不是做体检的最佳时机？</h4>
					<p>答：身体很不舒服，最好尽快到专科门诊就医治疗。体检的目的，是希望在疾病尚未出现明显症状前，及早检查处于萌芽状态的疾病并加以治疗。当已经处于疾病的急性发作期，应先到专科诊断治疗，待疾病康复后再做健康检查</p>
				</div>
				<div class="grid-list">
					<h4>问题五：没检查没感觉没毛病，一检查到处都是病，何必自找麻烦？</h4>
					<p>答：这是“掩耳盗铃”式的错误想法。许多健康受损或疾病早期，都是不太容易感觉到的，特别是忙碌的人们，通常会以为是休息不够或太劳累的结果，往往会麻痹大意把健康问题疏漏了，拖到“大病”才不得不去看医生，似乎有些“亡羊补牢”的感觉</p>
				</div>
				<div class="grid-list">
					<h4>问题六：抽血检查可以查出癌症吗？</h4>
					<p>答：通过抽血检查，可以帮助医生判断是否发生某些癌症，但不能筛检所有癌症。换言之，医生只能根据检查结果的提示，是否有某种癌症，而不能判断出是否没有某种癌症或其他癌症。如果结合B超、X线、CT、核磁共振等检查，有助于提高癌症的早期发现概率</p>
				</div>
				<div class="grid-list">&nbsp;
				</div>
				<div class="grid-list">&nbsp;
				</div>
				<div class="grid-list">&nbsp;
				</div>
				<div class="grid-list">
					<h4>问题七：健康检查可以筛检所有性病？</h4>
					<p>答：性病有很多种，包括梅毒、艾滋病、淋病、衣原体、支原体感染及病毒湿疣等，健康体检套餐一般不包括性病检查项目，这涉及个人隐私权和选择权。如您认为有必要，可以到妇科、泌尿科、性病专科去检查</p>
				</div>
				<div class="grid-list">
					<h4>问题八：B超检查对人体有害吗？</h4>
					<p>答：超音波检查是将仪器探头放在身体上，以感应音波回音，并在显示屏上变成影像，用以判断器官有无形态上或组织上的变化，是一种无创性检查，不会对人体造成损害</p>
				</div>
				<div class="grid-list">
					<h4>问题九：不要告诉医生太多病史，这样才能了解体检准不准？</h4>
					<p>答：医生需要结合您的病史或健康史，才能更好地评估您的健康现状。否则，只能孤立地告诉您某些检查结果，而难以做出判断。您既往有什么疾病状况、不良习惯或感受等，最好主动与医生沟通</p>
				</div>
			</div>
		</div>
		<div class="sidebar-2">
			<h3>健康等级</h3>
			<blockquote>1957年世界卫生组织进一步表述关于健康状态为个体在一定环境、遗传条件下能够恰当地表达其行为的功能，并在1984年进一步补充健康的分级：
			</blockquote>
			<div class="grids">
				<h4>第一级健康(躯体健康):</h4>
				<p>包括无饥寒、无病弱，能够精力充沛地生活和劳动，满足基本卫生要求</p>
			</div>
			<div class="grids">
				<h4>第二级健康(身心健康):</h4>
				<p>包括满足基本的经济要求，日常生活自由</p>
			</div>
			<div class="grids">
				<h4>第三级健康(主动健康):</h4>
				<p>包括能够主动追求健康的生活方式，调节心理状态适应社会和工作的压力，过着为社会做贡献的生活方式</p>
			</div>
			<div class="clear"></div>
			<h3>体检五忌</h3>
			<blockquote>健康体检，是预防疾病的有效手段之一。通过健康体检，可以了解自身健康状况，发现一些不易察觉的早期疾病，以便及时干预、终止疾病的发生发展，收到事半功倍的效果。但有不少受检者由于对体检的一些关键环节重视不够，或认识偏差，出现种种疏漏，使体检的目的难以达到。
			</blockquote>
			<div class="grids">
				<h4>一、忌采血时间太晚（7：30～8：30空腹）</h4>
			</div>
			<div class="grids">
				<h4>二、忌体检前贸然停药（慢性病患者服药继续）</h4>
			</div>
			<div class="grids">
				<h4>三、忌随意舍弃检查项目（每个项目都有其意义）</h4>
			</div>
			<div class="grids">
				<h4>四、忌忽略重要病史陈述（对于医生判断很重要）</h4>
			</div>
			<div class="grids">
				<h4>五、忌轻视体检结论（对预防疾病有指导意义）</h4>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
