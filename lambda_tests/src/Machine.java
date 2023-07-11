public class Machine <T> {



    public T MonoOperation(T item, MonoOperation <T> monoOperation){
        return monoOperation.monoOperation(item);
    }

    public T BiOperation(T item, T item2, BiOperation <T> biOperation){
        return biOperation.biOperation(item,item2);
    }




    public static void main(String[] args) {

        Machine<Integer> machine = new Machine();
        Integer result = machine.MonoOperation(2, n -> n * 5);
        System.out.println(result);

        Integer doubleOf2 = machine.MonoOperation(2,(x)-> 2 * x);
        System.out.println(doubleOf2);


        Machine<String> stringMachine = new Machine<>();
        String resultFromString = stringMachine.MonoOperation("hello", n -> n.toUpperCase());
        System.out.println(resultFromString);

        Integer resul2 = machine.BiOperation(8,2, (x,y)-> x + y);

        System.out.println(resul2);


    }
}
