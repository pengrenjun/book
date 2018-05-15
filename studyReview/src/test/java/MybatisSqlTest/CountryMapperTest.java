package MybatisSqlTest;

import MybatisExc.Util.SqlsessionUtil;
import MybatisExc.entity.Country;
import MybatisExc.mapper.CountryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CountryMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init(){
		try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
        	ignore.printStackTrace();
        }
	}
	
	@Test
	public void selectByPrimaryKey() throws IOException {
		try {
			CountryMapper countryMapper = SqlsessionUtil.getMapperByClass(CountryMapper.class);
			Country country = countryMapper.selectByPrimaryKey(1);
			System.out.println(country.getCountryname());
		} finally {
			SqlsessionUtil.closeSession();
		}
	}

}
