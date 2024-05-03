package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.file;
import sacembackned.com.repository.fileRepository;

@Service
public class fileServiceImpl implements fileservice {

  @Autowired
  private fileRepository fileRepository;

  @Override
  public List<file> list() {
    return fileRepository.findAll();
  }

  @Override
  public file save(file file) {
    return fileRepository.save(file);
  }

  @Override
  public Optional<file> getOne(int id) {
    return fileRepository.findById(id);
  }

  @Override
  public void delete(int id) {
    fileRepository.deleteById(id);
  }
}
