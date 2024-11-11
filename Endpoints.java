@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private DepositoService depositoService = DepositoService.getInstance();

    @GetMapping("/deposito/{numeroConta}")
    public List<Deposito> listarDepositosPorConta(@PathVariable Long numeroConta) {
        return depositoService.getDepositosPorConta(numeroConta);
    }

    @GetMapping("/deposito")
    public List<Deposito> listarTodosDepositos() {
        return depositoService.getTodosDepositos();
    }

    @PostMapping("/deposito/{numeroConta}")
    public ResponseEntity<String> realizarDeposito(@PathVariable Long numeroConta, @RequestParam double valor) {
        if (valor <= 0 || valor > 5000) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("O valor do depósito deve ser maior que 0 e menor que R$5.000,00.");
        }
        
        Deposito novoDeposito = new Deposito(numeroConta, valor);
        depositoService.adicionarDeposito(novoDeposito);
        return ResponseEntity.ok("Depósito realizado com sucesso.");
    }
}
