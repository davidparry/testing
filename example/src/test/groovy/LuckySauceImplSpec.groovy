import com.davidparry.service.LuckySauceImpl
import com.davidparry.service.RandomWrapper

class LuckySauceImplSpec extends spock.lang.Specification {


    def "call getLucky Sauce test"() {
        setup:
        def randomWrapper = Mock(RandomWrapper)
        def luckySauce = new LuckySauceImpl(randomWrapper)


        when: "expect that 10L is returned which came  from mock"
        luckySauce.getLuckySauce() == 10L

        then: "call to mock return value"
        1 * randomWrapper.nextLong() >> 10L
    }

}
