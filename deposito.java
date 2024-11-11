@PostMapping("/contas/{id}/deposito")
public ResponseEntity<String> realizarDeposito(@PathVariable Long id, @RequestParam double valor) {
    if (valor <= 0 || valor > 5000) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("O valor do depósito deve ser maior que 0 e menor que R$5.000,00.");
    }
    // Lógica para realizar o depósito
    // ...
    return ResponseEntity.ok("Depósito realizado com sucesso.");
}
