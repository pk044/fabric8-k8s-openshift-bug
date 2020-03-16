import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import java.io.FileInputStream;

public class Sample {
    public static void main(String[] args) throws Exception {
        DefaultOpenShiftClient client = new DefaultOpenShiftClient();

        client.deploymentConfigs().inNamespace("default").list().getItems().forEach(workload -> System.out.println(workload.getMetadata().getName())); //actually lists

        client.load(Sample.class.getResourceAsStream("example.yml")).get(); // throws NPE
    }
}
