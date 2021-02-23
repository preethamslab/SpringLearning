package snippet;

public class Snippet {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
		public CurrencyExchance retrieveExchangeValue(@PathVariable String from,
				@PathVariable String to)
		{
			return new CurrencyExchance(1000L,from ,to, BigDecimal.valueOf(50));
		}
}

