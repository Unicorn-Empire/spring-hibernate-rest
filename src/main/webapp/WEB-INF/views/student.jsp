<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="modal-header" >
         <h3 class="modal-title">New Student</h3>
        </div>
        <form:form name="student" ng-modal="student">
        <div class="modal-body">
            <input type="hidden" name="id" ng-model="student.id"/>
            <table class="table">
            <tr>
            <td><label>enroll No</label></td><td><input type="text" ng-model= "student.enrollNo"/></td>
            </tr> <tr>
            <td><label>roll No</label></td><td><input type="text" ng-model="student.rollNo"/></td>
            </tr><tr>
             <td><label>name</label></td><td><input type="text" ng-model="student.name"/></td>
            </tr><tr>
            <td><label>grade</label></td>
            <td>
            <select name="grade" ng-model="student.grade" ng-model="selected" ng-options="grade as grade for grade in grades"></select>
            </td>
            </tr><tr>
            <td><label>dept</label></td>
            <td>
            <select name="dept" ng-model="student.dept" ng-model="selected" ng-options="dept as dept for dept in depts"> </select>
            </td>
            </tr>
            </table>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" ng-click="enrollStudent()">Enroll</button>
            <button class="btn btn-warning" ng-click="cancel()">Cancel</button>
        </div>
        </form:form>       