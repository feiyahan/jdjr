
<style type="text/css">
    #line-chart {
        height:300px;
        width:800px;
        margin: 0px auto;
        margin-top: 1em;
    }
    .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
        color: #fff;
    }
</style>
<#-- 顶部菜单导航 -->
<div class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Feiyahan</span></a>
    </div>

    <div class="navbar-collapse collapse" style="height: 1px;">
        <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> ${currentUser.username}
                    <i class="fa fa-caret-down"></i>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="">My Account</a></li>
                    <li class="divider"></li>
                    <li class="dropdown-header">Admin Panel</li>
                    <li><a href="">Users</a></li>
                    <li><a href="">Security</a></li>
                    <li><a tabindex="-1" href="">Payments</a></li>
                    <li class="divider"></li>
                    <li><a tabindex="-1" href="/logout">Logout</a></li>
                </ul>
            </li>
        </ul>

    </div>
</div>