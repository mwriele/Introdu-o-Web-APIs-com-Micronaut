public class DepositoService {
    private static DepositoService instance;
    private List<Deposito> depositos = new ArrayList<>();

    private DepositoService() {}

    public static synchronized DepositoService getInstance() {
        if (instance == null) {
            instance = new DepositoService();
        }
        return instance;
    }

    public void adicionarDeposito(Deposito deposito) {
        depositos.add(deposito);
    }

    public List<Deposito> getDepositosPorConta(Long numeroConta) {
        return depositos.stream()
                .filter(deposito -> deposito.getNumeroConta().equals(numeroConta))
                .collect(Collectors.toList());
    }

    public List<Deposito> getTodosDepositos() {
        return new ArrayList<>(depositos);
    }
}
