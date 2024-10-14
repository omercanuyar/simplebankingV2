SimpleBankingV2

[ENG]

The project is designed as an application that models a banking service, managing various transaction types (such as deposits, withdrawals, bill payments, etc.). The Account class stores essential information such as the account owner's name, account number, and balance. The Transaction class contains common attributes (amount, date) for all transaction types, while subclasses (such as DepositTransaction, WithdrawalTransaction, BillPaymentTransaction, etc.) implement their specific functionality through the process method. This structure leverages polymorphism, allowing the single post method in the Account class to dynamically handle different transaction types, thus eliminating the need for modifications to the Account class when adding new transaction types. The REST API, built using Spring Boot, provides the necessary endpoints for performing operations like depositing and withdrawing money from accounts, enabling the tracking of transactions with approval codes.

[TR]

Proje, bir banka hizmetini modelleyen bir uygulama olarak, farklı işlem türlerini (depozit, çekim, fatura ödemesi vb.) yönetmek üzere tasarlanmıştır ve Account sınıfı, hesap sahibi adı, hesap numarası ve bakiye gibi temel bilgileri saklamaktadır. Transaction sınıfı, tüm işlem türleri için ortak özellikleri (miktar, tarih) barındırırken, alt sınıflar (DepositTransaction, WithdrawalTransaction, BillPaymentTransaction, vb.) kendi spesifik işlevselliklerini process metoduyla gerçekleştirir. Bu yapı, polimorfizm kullanılarak, Account sınıfındaki tek bir post metodu aracılığıyla işlem türlerinin dinamik olarak işlenmesini sağlar; böylece yeni işlem türleri eklenirken Account sınıfında değişiklik yapılmasına gerek kalmaz. REST API, Spring Boot kullanılarak, hesaplara para yatırma ve çekme gibi işlemleri gerçekleştirmek için gerekli uç noktaları sağlar ve işlemlerin onay kodlarıyla takip edilmesine olanak tanır.

Ömer Can Uyar
