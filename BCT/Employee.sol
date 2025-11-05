//SPDX-License-Identifier:MIT

pragma solidity^0.8.0;

contract EmployeeWork{
    struct Employee{
         uint id;
        string name;
        uint salary;
        string joiningDate;
    }
    Employee[] public employee;

    //create Employee
    function createEmployee( uint id,
        string memory name,
        uint salary,
        string memory joiningDate
    ) public{
        employee.push(Employee(id,name,salary,joiningDate));
    }

    //display Employee
    function displayEmp (uint256 index) public view returns(uint,string memory , uint,string memory){
        require(index < employee.length,"Employee does not exist");
        return (employee[index].id,employee[index].name,employee[index].salary,employee[index].joiningDate);
    }

}