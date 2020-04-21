[Test Method]
public void TestTransferFunds()
{
    // Arrange
    ICurrencyService currencyService = Mock.Create<ICurrencyService>();
    Mock.Arrange(() => currencyService.GetConversionRate("GBP", "CAD"))
       .Returns(2.20m).MustBeCalled();
 
    var accountService = new AccountService(currencyService);
    var canadianAccount = new Account(0, "CAD");
    var britishAccount = new Account(0, "GBP");
 
    // Act
    britishAccount.Deposit(100);
    accountService.TransferFunds(britishAccount, canadianAccount, 100);
 
    // Assert
    Assert.AreEqual(0, britishAccount.Balance);
    Assert.AreEqual(220, canadianAccount.Balance);
    Mock.Assert(currencyService);
}