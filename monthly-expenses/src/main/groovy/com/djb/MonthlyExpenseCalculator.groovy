/**
 * Created by dblau on 1/31/16.
 */
package com.djb

interface MonthlyAccountableEntity {
    Float getMonthlyAllocationExpense()
}

class QATester implements MonthlyAccountableEntity {
    @Override
    Float getMonthlyAllocationExpense() {
        return Department.monthlyAllocationsByClass.tester
    }
}
class Developer implements MonthlyAccountableEntity {
    @Override
    Float getMonthlyAllocationExpense() {
        return Department.monthlyAllocationsByClass.developer
    }
}

class Manager implements MonthlyAccountableEntity {
    private List<MonthlyAccountableEntity> employees = []

    @Override
    Float getMonthlyAllocationExpense() {
        Float monthlyExpense = Department.monthlyAllocationsByClass.manager
        for(employee in employees) {
            monthlyExpense += employee?.getMonthlyAllocationExpense()
        }
        return monthlyExpense
    }

    def addEmployee(MonthlyAccountableEntity employee) { this.employees << employee }
}

final class Department implements MonthlyAccountableEntity {
    static monthlyAllocationsByClass = [manager: 300f, tester: 500f, developer: 1000f]
    private List<Manager> managers = []

    def addManager(Manager manager) { this.managers << manager }

    @Override
    Float getMonthlyAllocationExpense() {
        Float total = 0f
        managers?.each { manager ->
            total += manager?.getMonthlyAllocationExpense()
        }
        return total
    }
}

