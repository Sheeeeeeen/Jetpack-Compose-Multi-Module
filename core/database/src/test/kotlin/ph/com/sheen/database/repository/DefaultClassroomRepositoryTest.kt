//package ph.com.sheen.database.repository
//
//import app.cash.turbine.test
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.asFlow
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test
//import ph.com.sheen.database.ClassroomEntity
//import ph.com.sheen.database.dao.ClassroomDao
//import java.util.UUID
//
//class DefaultClassroomRepositoryTest {
//
//    //TODO Create unit test first on room database
//    private lateinit var classroomDao: ClassroomDao
//
//    private lateinit var defaultClassroomRepository: DefaultClassroomRepository
//
//    @Before
//    fun setup() {
//        val classrooms = mutableListOf<List<ClassroomEntity>>()
//        classroomDao = object : ClassroomDao {
//            override fun getAllClassroom(): Flow<List<ClassroomEntity>> {
//                insertEmpty()
//                return classrooms.asFlow()
//            }
//
//            override fun insert(classroomEntity: ClassroomEntity) {
//                classrooms.add(index = 0, element = listOf(classroomEntity))
//            }
//
//            fun insertEmpty(list: List<ClassroomEntity> = emptyList()) {
//                classrooms.add(list)
//            }
//
//            override fun deleteClassroom(classroomEntity: ClassroomEntity) {
//                classrooms.removeIf {
//                    it.contains(classroomEntity)
//                }
//            }
//
//            override fun updateClassroom(classroomEntity: ClassroomEntity) {
//                TODO("TO be implement")
//            }
//        }
//        defaultClassroomRepository = DefaultClassroomRepository(dao = classroomDao)
//    }
//
//    //retrieve list of classroom
//    @Test
//    fun `test retrieval of classrooms has empty list`() = runTest {
//        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
//        listOfClassroom.test {
//            assertTrue(awaitItem().isEmpty())
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//
//    //add classroom
//    @Test
//    fun `test add classroom with 1 item on list`() = runTest {
//        val id = UUID.randomUUID()
//        val insertedClassroomEntity = ClassroomEntity(id = id)
//        val classroomModel = insertedClassroomEntity.toModel()
//        defaultClassroomRepository.saveClassroom(classroom = classroomModel)
//        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
//        listOfClassroom.test {
//            val classrooms = awaitItem()
//            val filterClassroom = classrooms.first { it.id == id }
//            assertTrue(filterClassroom == insertedClassroomEntity.toModel())
//            assertTrue(classrooms.isNotEmpty())
//            cancelAndConsumeRemainingEvents()
//        }
//    }
//
//    //retrieve classroom via id
//    @Test
//    fun `test retrieve classroom via id`() = runTest {
//        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
//        listOfClassroom.test {
//            val classrooms = awaitItem()
//            assertTrue(classrooms.isEmpty())
//            cancelAndConsumeRemainingEvents()
//        }
//    }
//
//    //delete classroom
//    @Test
//    fun `test delete classroom`() = runTest {
//        val id = UUID.randomUUID()
//        val insertedClassroomEntity = ClassroomEntity(id = id)
//        val classroomModel = insertedClassroomEntity.toModel()
//        defaultClassroomRepository.saveClassroom(classroom = classroomModel)
//        defaultClassroomRepository.deleteClassroom(classroom = classroomModel)
//        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
//        listOfClassroom.test {
//            val classrooms = awaitItem()
//            assertTrue(classrooms.isEmpty())
//            cancelAndConsumeRemainingEvents()
//        }
//    }
//
//    //update classroom
//    @Test
//    fun `test update classroom`() = runTest {
//        val id = UUID.randomUUID()
//        val insertedClassroomEntity = ClassroomEntity(id = id)
//        val classroomModel = insertedClassroomEntity.toModel()
//        defaultClassroomRepository.saveClassroom(classroom = classroomModel)
//        defaultClassroomRepository.updateClassroom(classroom = classroomModel)
//        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
//        listOfClassroom.test {
//            val classrooms = awaitItem()
//            assertTrue(classrooms.isEmpty())
//            cancelAndConsumeRemainingEvents()
//        }
//    }
//}