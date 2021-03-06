<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
                    <div class="row">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h4 class="widget-title">Cập Nhật Thông Tin Toà Nhà</h4>
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <!-- PAGE CONTENT BEGINS -->
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for="name"> Tên Toà Nhà </label>
                                                        <input type="text" id="name" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <div>
                                                        <label for=""> Diện Tích Sàn </label>
                                                        <input type="number" id="rentArea" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Quận Huyện</label>
	                                         		<select class="form-control" id="form-field-select-1">
													<option value="">--Quận Huyện--</option>
													<option value="a">aa</option>
													<option value="b">bb</option>
													<option value="c">cc</option>
													</select>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Phường</label>
                                                    <input type="text" id="ward" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Đường</label>
                                                    <input type="text" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Số Tầng Hầm</label>
                                                    <input type="number" id="bumberOfBasesment" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Hướng</label>
                                                    <input type="text" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Hạng</label>
                                                    <input type="text" id="level" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Diện tích thuê</label>
                                                    <input type="number" id="rentArea" class="form-control" />
                                                </div>
                                             
                                                <div class="col-sm-3">
                                                    <label for="">Giá thuê </label>
                                                    <input type="number" id="rentCost" class="form-control" />
                                                </div>
                                                
                                                <div class="col-sm-3">
                                                    <label for="">Giá thuê đến</label>
                                                    <input type="number" id="rentCostTo" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Tên quản lý</label>
                                                    <input type="text" id="managerName" class="form-control" />
                                                </div>
                                                <div class="col-sm-4">
                                                    <label for="">Điện thoại quản lý</label>
                                                    <input type="text" id="managerPhone" class="form-control" />
                                                </div>
                                                <div class="col-sm-3">
                                                    <label for="">Chọn nhân viên phụ trách</label>
                                                    <select class="form-control" id="form-field-select-1">
													<option value="">--Chọn Nhân Viên Phụ Trách--</option>
													<option value="a">aa</option>
													<option value="b">bb</option>
													<option value="c">cc</option>
													</select>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="control-group">
                                                        <label class="control-label bolder blue">Loại toà nhà</label>
                                                        <div class="checkbox">
                                                            <label>
														<input name="form-field-checkbox" type="checkbox" class="ace">
														<span class="lbl">Tầng Trệt</span>
													</label>
                                                            <label>
														<input name="form-field-checkbox" type="checkbox" class="ace">
														<span class="lbl">Nguyên Căn</span>
													</label>
                                                            <label>
														<input name="form-field-checkbox" type="checkbox" class="ace">
														<span class="lbl">Nội Thất</span>
													</label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-12">
                                                    <div class="pull-left" data-toggle="tooltip" title="Thêm Toà Nhà">
                                                        <button class="btn btn-sucess btn-info btn-bold">
												Cập Nhật Toà Nhà
											</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- PAGE CONTENT ENDS -->
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                </div>
                            </div>
                        </div>                                      
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
</body>
</html>