/**
 * Created by dblau on 1/31/16.
 */
package com.djb

abstract class Employee {
    Float allocation = 0f
    Float getMonthlyExpense() { return this.allocation }
}

class QATester extends Employee {
    @Override
    Float getMonthlyExpense() {
        return Department.monthlyAllocationsByClass.tester
    }
}
class Developer extends  Employee {
    @Override
    Float getMonthlyExpense() {
        return Department.monthlyAllocationsByClass.developer
    }
}
class Manager extends Employee {
    List<Employee> subordinates = []

    @Override
    Float getMonthlyExpense() {
        Float monthlyExpense = Department.monthlyAllocationsByClass.manager
        for(employee in subordinates) {
            monthlyExpense += employee?.getMonthlyExpense()
        }
        return monthlyExpense
    }
}

final class Department {
    static monthlyAllocationsByClass = [manager: 300f, tester: 500f, developer: 1000f]
    List employees = []

    def addEmployee(employee) { this.employees << employee }

    public def getMonthlyExpense() {
        Float total = 0f
        employees?.each { Employee employee ->
            total += employee?.getMonthlyExpense()
        }
        return total
    }

}

