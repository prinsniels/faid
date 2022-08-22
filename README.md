

Balance => Container storing an intermediate value, representing the value after a sequence of mutations
Mutation => Change on a Balance
Category => Why the mutation occurred, like Mortgage, insurance Etc
Jar => A container holding an amount available to spend on a Category during a given month. You take from the jar during the month.

jar : Period, Category, StartBalance, CurrentBalance

Goal:
- insight in spending vs income per month
- insight in spending vs reserved per month


suggestion :: Mutation => Option[Category]

 TODO: Assign bucket to transaction
        (
            Boodschapen,
            Kleding,
            Overig,
            Media,
            Verzekeringen,
            Water/Licht,
            Lasten, -> Kosten afval, gemeentelijke lasten etc.
            Hypotheek
        )
 TODO: Persist mutatio -> bucket
 TODO: Bucket utalization per month
 TODO: Bucket statisticts per .....
 TODO: Bucket suggestion