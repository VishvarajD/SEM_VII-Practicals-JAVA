//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

//mapping 
contract Bank {
mapping(address => uint256) private balances;

//create account 
function createAccount() public {
    balances[msg.sender] = 0;
}

//deposit 
function deposit(uint256 amount) public payable {
    balances[msg.sender] += amount;
}
//transfer
function transfer(address reciptent , uint256 amount) public {
    require(balances[msg.sender] >= amount , "Fucked up due to low balance");
    balances[msg.sender] -= amount;
    balances[reciptent] += amount;
}
//withdraw
function withdraw(uint amount) public payable {
    require(balances[msg.sender] >= amount , "Fucked up due to low balance");
    balances[msg.sender] -= amount;
}
//getBalance
function getBalance()view public returns(uint256){
    return balances[msg.sender];
}
}